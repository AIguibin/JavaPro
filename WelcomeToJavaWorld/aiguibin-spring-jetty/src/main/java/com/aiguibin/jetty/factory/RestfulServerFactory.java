package com.aiguibin.jetty.factory;

import com.aiguibin.jetty.bean.RestfulServerConfigBean;
import com.aiguibin.jetty.helper.StringHelper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.jetty.server.Handler;
import org.glassfish.jersey.jetty.JettyHttpContainer;
import org.glassfish.jersey.jetty.JettyHttpContainerProvider;
import org.glassfish.jersey.server.ContainerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.UriConnegFilter;
import org.springframework.context.ApplicationContext;
import org.springframework.web.filter.RequestContextFilter;

import java.util.List;

public class RestfulServerFactory extends HttpServerFactory{
    private static final Log logger = LogFactory.getLog(RestfulServerFactory.class);

    private ApplicationContext context;
    private RestfulServerConfigBean restfulServerConfigBean;

    /**
     * 默认的构造函数
     *
     * @param context                 Spring IoC上下文
     * @param restfulServerConfigBean RESTful配置对象
     */
    public RestfulServerFactory(ApplicationContext context, RestfulServerConfigBean restfulServerConfigBean) {
        super(restfulServerConfigBean);
        this.context = context;
        this.restfulServerConfigBean = restfulServerConfigBean;
    }

    /**
     * {@inheritDoc}
     *
     * @see HttpServerFactory#getHandler()
     */
    @Override
    protected Handler getHandler() {
        String[] serverClasses = restfulServerConfigBean.getServiceClasses();
        if (serverClasses == null || serverClasses.length <= 0) {
            if (logger.isWarnEnabled()) {
                logger.warn("You not define any restful service resource, will not create the HttpServer.");
            }
            return null;
        } else {
            ResourceConfig config = new ResourceConfig();
            config.register(UriConnegFilter.class);
            config.register(JettyHttpContainerProvider.class);
            config.register(RequestContextFilter.class);
            for (String classesDef : serverClasses) {
                if (!StringHelper.isBlank(classesDef)) {
                    List<Class<?>> restfulClasses = (List) context.getBean(classesDef, List.class);
                    if (!restfulClasses.isEmpty()) {
                        /*
                         * 如果引入对象实例，将导致Provider接口警告，修改为注册类；
                         * 然后将ApplicationContext手工注入
                         */
                        restfulClasses.forEach(config::register);
                    }
                }
            }
            /*
             * 为了使用Spring IoC注入，需要将ApplicationContext事先注入
             */
            config.property("contextConfig", context);
            return ContainerFactory.createContainer(JettyHttpContainer.class, config);
        }
    }
}
