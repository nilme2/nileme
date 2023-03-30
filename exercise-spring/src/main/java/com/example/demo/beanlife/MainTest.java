package com.example.demo.beanlife;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {

    public static void main(String[] args) {

        System.out.println("现在开始初始化容器");
        
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean-life.xml");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        System.out.println("容器初始化成功");    
        //得到Preson，并使用
        Person person = context.getBean("person",Person.class);
        System.out.println(person);
        
        System.out.println("现在开始关闭容器！");
        context.registerShutdownHook();
    }

}