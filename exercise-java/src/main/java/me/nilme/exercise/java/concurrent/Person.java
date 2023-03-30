package me.nilme.exercise.java.concurrent;

/**
 * Created by nilme on 2020/2/18.
 */
public class Person {

    private String name;
    private String pwd1;
    private int age;

    public Person(String name, String pwd1, int age) {
        this.name = name;
        this.pwd1 = pwd1;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd1() {
        return pwd1;
    }

    public void setPwd1(String pwd1) {
        this.pwd1 = pwd1;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
