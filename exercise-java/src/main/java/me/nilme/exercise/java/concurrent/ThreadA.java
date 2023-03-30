package me.nilme.exercise.java.concurrent;

/**
 * @author weizhuang
 * Created on 2019-05-16.
 */
public class ThreadA extends Thread {

    private ObjectA objectA;

    public ThreadA(ObjectA objectA) {
        this.objectA = objectA;
    }

    @Override
    public void run() {
        long i = 0;
        while (objectA.isFlag()) {
            i++;
        }
        System.out.println("stop My Thread " + i);
    }
}
