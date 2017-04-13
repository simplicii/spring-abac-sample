package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.abac.AbacMethodSecurityExpressionHandler;
import org.springframework.security.abac.service.jdbc.JdbcPolicyServiceImpl;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;

import javax.sql.DataSource;

/**
 * @author Renato Soppelsa
 * 2017
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {

    @Autowired
    private ApplicationContext applicationContext;

    @Bean
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Override
    protected MethodSecurityExpressionHandler createExpressionHandler() {
        AbacMethodSecurityExpressionHandler expressionHandler = new AbacMethodSecurityExpressionHandler(applicationContext, new JdbcPolicyServiceImpl(dataSource()));
        return expressionHandler;
    }

}
