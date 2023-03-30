package me.nilme.exercise.java.proxy.doublemetch.jdk;

/**
 * Created by nilme on 2020/2/28.
 */
public class Main {

    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
//        System.setProperty("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
        // JDK 动态代理调用
        AnimalProxy proxy = new AnimalProxy();
        Cat cat = new Cat();
        Animal catProxy = (Animal) proxy.getInstance(cat);
        cat.setTargte(catProxy);
        catProxy.eat();
        System.out.println("------------------");
        catProxy.run();
    }
}
