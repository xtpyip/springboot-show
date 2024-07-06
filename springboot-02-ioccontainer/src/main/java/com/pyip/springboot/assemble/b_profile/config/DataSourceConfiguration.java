package com.pyip.springboot.assemble.b_profile.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

/**
 * @ClassName: DataSourceConfiguration
 * @version: 1.0
 * @Author: pyipXt
 * @Description: 不同的profile
 **/
@Configuration
public class DataSourceConfiguration {
    @Bean
    @Profile("dev")
    public DataSource devDataSource() {
        return null;
    }

    @Bean
    @Profile("test")
    public DataSource testDataSource() {
        return null;
    }

    @Bean
    @Profile("prod")
    public DataSource prodDataSource() {
        return null;
    }
}
