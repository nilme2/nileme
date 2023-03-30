package com.example.demo.base.scope;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Created by nilme on 2020/4/28.
 */
@Configuration
public class ScopeConfig {

    @Bean
    @Scope("prototype")
    public MyBean myBean(){
        return new MyBean("name");
    }
}
