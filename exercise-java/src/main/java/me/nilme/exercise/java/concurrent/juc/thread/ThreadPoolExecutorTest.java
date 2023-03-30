package me.nilme.exercise.java.concurrent.juc.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(10, 10,
                10L, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(2),
                new MyThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());
        threadPool.allowCoreThreadTimeOut(true);
        for (int i = 0; i < 10; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}