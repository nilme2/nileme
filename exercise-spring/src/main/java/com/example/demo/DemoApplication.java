package com.example.demo;

import com.example.demo.base.scope.MyBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);

        //单例测试
        MyBean myBean = context.getBean(MyBean.class);
        MyBean myBean2 = context.getBean(MyBean.class);
        System.out.println(myBean);
        System.out.println(myBean2);
    }

}
