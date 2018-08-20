package com.aiguibin.spring.config;

import org.springframework.context.annotation.Bean;
/**
 * 描述： 
 *
 * @author AIguibin Date time 2018/8/8 12:04
 */
public class SpringConfig {
    public SpringConfig() {
    }

    @Bean
    public SpringContextHolder springContextHolder() {
        return new SpringContextHolder();
    }
}
