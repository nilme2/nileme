package me.nilme.exercise.java.concurrent.jiaotidaying;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by nilme on 2020/4/16.
 */
public class OldEvenTest3 {
    //保证flag的线程可见性
    private static volatile Boolean flag = true;

    private static AtomicInteger num = new AtomicInteger();

    private static final Integer TOTAL = 100;

    public static void main(String[] args) {
        method3();
    }

    private static void method3() {
        Thread jsThread = new Thread(() -> {
            while (num.get() <= TOTAL - 1) {
                if (!flag) {
                    System.out.println(Thread.currentThread().getName() + ": "
                            + num.getAndIncrement());
                    flag = true;
                }
            }
        });
        jsThread.setName("奇数线程");

        Thread osThread = new Thread(() -> {

            while (num.get() <= TOTAL) {
                if (flag) {
                    System.out.println(Thread.currentThread().getName() + ":"
                            + num.getAndIncrement());
                    flag = false;
                }
            }
        });
        osThread.setName("偶数线程");

        osThread.start();
        jsThread.start();
    }
}
