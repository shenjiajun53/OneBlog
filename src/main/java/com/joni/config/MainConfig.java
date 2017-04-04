package com.joni.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Configuration;

/**
 * Created by shenjiajun on 2017/4/4.
 */

@Configuration
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class MainConfig {
}
