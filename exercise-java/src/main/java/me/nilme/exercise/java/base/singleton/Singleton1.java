package me.nilme.exercise.java.base.singleton;

/**
 * Created by nilme on 2020/4/20.
 */
public class Singleton1 {
    private static Singleton1 singleton;

    private Singleton1(){

    }

    public static Singleton1 getInstance(){
        if (singleton == null){
            synchronized (Singleton1.class){
                if (singleton == null){
                    singleton = new Singleton1();
                }
            }
        }
        return singleton;
    }

}
