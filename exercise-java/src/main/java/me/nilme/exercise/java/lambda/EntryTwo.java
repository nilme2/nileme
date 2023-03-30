package me.nilme.exercise.java.lambda;

/**
 * Created by nilme on 2020/4/28.
 */
public class EntryTwo {

    public static void main(String[] args) {
        SampleService service = () -> "Hello";

        SampleService service2 = new SampleService() {
            @Override
            public String say() {
                return "匿名接口类say";
            }
        };

        System.out.println(service2.say());

        System.out.println(service.say());
    }

}
