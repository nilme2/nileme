package me.nilme.exercise.java.base.singleton;

public class Singleton {

    private volatile Singleton singleton = null;


    public Singleton getSingleton() {

        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
