package me.nilme.exercise.java.lambda;

/**
 * Created by nilme on 2020/4/28.
 */
public class DelegateService {

    public String name;

    public DelegateService(String name) {
        this.name = name;
    }

    public void say() {
        String desc = "DelegateService#say";
        SampleService service = () -> name + ":" + desc;
        System.out.println(service.say());
    }
}
