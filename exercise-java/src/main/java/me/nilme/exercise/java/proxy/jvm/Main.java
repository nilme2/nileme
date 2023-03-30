package me.nilme.exercise.java.proxy.jvm;

/**
 * Created by nilme on 2020/2/28.
 */
public class Main {

    public static void main(String[] args) {
        // JDK 动态代理调用
        AnimalProxy proxy = new AnimalProxy();
        Animal dogProxy = (Animal) proxy.getInstance(new Dog());
        dogProxy.eat();
    }
}
