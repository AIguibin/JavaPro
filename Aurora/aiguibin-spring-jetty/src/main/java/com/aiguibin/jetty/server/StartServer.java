package com.aiguibin.jetty.server;

import com.aiguibin.jetty.config.JettyConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
/**
 * 描述： 
 *
 * @author AIguibin Date time 2018/8/9 9:19
 */
public class StartServer {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(JettyConfig.class);
        System.out.println("Press any key to shutdown......");
        System.in.read();
        context.close();
    }
}
