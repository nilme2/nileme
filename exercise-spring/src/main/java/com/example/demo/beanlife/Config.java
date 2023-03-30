package com.example.demo.beanlife;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

/**
 * Created by nilme on 2020/3/20.
 */
@Configurable
public class Config {

    @Bean
    public MyBeanFactoryPostProcessor getMyBeanFactoryPostProcessor(){
        return new MyBeanFactoryPostProcessor();
    }

    @Bean
    public MyBeanPostProcessor getMyBeanPostProcessor(){
        return new MyBeanPostProcessor();
    }

    @Bean
    public MyInstantiationAwareBeanPostProcessor getMyInstantiationAwareBeanPostProcessor(){
        return new MyInstantiationAwareBeanPostProcessor();
    }


    @Bean(initMethod = "myInit", destroyMethod = "myDestory", name = "person")
    public Person getPerson(){
        return new Person();
    }

}
