package me.nilme.exercise.java.concurrent;

/**
 * Created by nilme on 2020/3/2.
 */
public class Singleton {

    private static class SingletonHolder {
        private static final Singleton SINGLETON = new Singleton();
    }

    public Singleton singleton() {
        return SingletonHolder.SINGLETON;
    }

}
