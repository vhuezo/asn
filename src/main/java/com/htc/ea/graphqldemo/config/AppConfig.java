package com.htc.ea.graphqldemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.htc.ea.core.config.CoreConfigentryConfig;

@Configuration
@Import({ CoreConfigentryConfig.class })
public class AppConfig {

}
