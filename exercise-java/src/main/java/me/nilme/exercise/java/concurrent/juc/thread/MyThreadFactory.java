package me.nilme.exercise.java.concurrent.juc.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

class MyThreadFactory implements ThreadFactory {
    private AtomicInteger count = new AtomicInteger(0);

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        String threadName = "MyThread" + count.addAndGet(1);
        t.setName(threadName);
        return t;
    }
}