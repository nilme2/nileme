package me.nilme.exercise.java.concurrent.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 使用AtomicReference,完成一个自定义的自旋锁
 */
public class SpinLock {

    private AtomicReference<Thread> cas = new AtomicReference<>();


    public void lock(){

        Thread current = Thread.currentThread();

        while(!cas.compareAndSet(null, current)){

        }
    }

    public void unlock(){
        Thread current = Thread.currentThread();
        cas.compareAndSet(current,null);
    }


}
