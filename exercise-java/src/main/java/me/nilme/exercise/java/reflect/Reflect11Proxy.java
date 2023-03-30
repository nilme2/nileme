package me.nilme.exercise.java.reflect;

/**
 * Created by weizhuang on 2019-03-28.
 */
public class Reflect11Proxy implements Subject {

    private RealSubject real;

    public static void main(String[] args) {
        Reflect11Proxy proxy = new Reflect11Proxy();

        proxy.Request();

    }

    public void Request() {
        if (null == real) {
            real = new RealSubject();
        }
        real.Request();
    }

    @Override
    public void hello(String world) {

    }
}
