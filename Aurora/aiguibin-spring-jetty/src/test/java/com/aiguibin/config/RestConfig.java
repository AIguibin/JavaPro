package com.aiguibin.config;

import com.aiguibin.action.FirstRestful;
import com.aiguibin.action.FirstServlet;
import com.aiguibin.jetty.config.ServerConfig;
import com.aiguibin.spring.config.SpringConfig;
import org.springframework.context.annotation.*;

import java.util.Arrays;
import java.util.List;

@Configuration
@Import({
        SpringConfig.class,
        ServerConfig.class
})
@PropertySource({
        "classpath:server.properties"
})
@ComponentScan({
        "com.aiguibin.action",
})
public class RestConfig {
    @Bean(name = "restfulClasses")
    public List<Class<?>> restfulClasses() {
        return Arrays.asList(FirstRestful.class);
    }
    @Bean(name = "servletClasses")
    public List<Class<?>> servletClasses(){
        return Arrays.asList(FirstServlet.class);
    }
    ///**
    // * 初始化线程池
    // *
    // * @return ThreadFactory
    // */
    //@Bean("initThreadFactory")
    //public ThreadFactory initThreadFactory() {
    //    ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
    //    ExecutorService singleThreadPool = new ThreadPoolExecutor(3, 10,
    //            10000L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(1024),
    //            namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
    //    singleThreadPool.execute(new Runnable() {
    //        @Override
    //        public void run() {
    //            System.out.println(Thread.currentThread().getName());
    //        }
    //    });
    //    singleThreadPool.shutdown();
    //
    //    return namedThreadFactory;
    //}
}
