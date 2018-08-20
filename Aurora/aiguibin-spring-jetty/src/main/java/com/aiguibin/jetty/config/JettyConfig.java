package com.aiguibin.jetty.config;

import com.aiguibin.spring.config.SpringConfig;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 描述： 这是一个web.xml
 *
 * @author AIguibin Date time 2018/8/9 0:11
 */
@Configuration
@Import(SpringConfig.class)
public class JettyConfig {
    private static final Log logger = LogFactory.getLog(JettyConfig.class);
    public void te(){
        logger.error("kkllll");
    }
}
