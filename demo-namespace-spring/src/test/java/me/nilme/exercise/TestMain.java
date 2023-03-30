package me.nilme.exercise;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by taoshanchang on 16/1/28.
 */
public class TestMain {

    @Test
    public void test() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        People people = (People) ctx.getBean("people");
        System.out.println(people.getId());
        System.out.println(people.getName());
        System.out.println(people.getAge());
    }

}
