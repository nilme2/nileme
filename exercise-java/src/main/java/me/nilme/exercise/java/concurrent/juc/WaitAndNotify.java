package me.nilme.exercise.java.concurrent.juc;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author weizhuang
 * Created on 2019-05-15.
 */
public class WaitAndNotify {

    private static final Object object = new Object();

    private static volatile AtomicBoolean flag = new AtomicBoolean(true);


    public static void main(String[] args) {
        WaitAndNotify waitAndNotify = new WaitAndNotify();
        waitAndNotify.test();
    }

    public void test(){
        Thread1 thread1  = new Thread1();
        Thread2 thread2  = new Thread2();

        thread1.start();
        thread2.start();

    }


    public class Thread1 extends Thread {

        @Override
        public void run() {
            System.out.println("进入线程1");

            synchronized (object) {
                while (flag.get()) {
                    System.out.println("进入循环");
                    try {
                        Thread.sleep(1000);
                        System.out.println("线程一开始等待");
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("线程1执行完成");
            }


        }
    }

    public class Thread2 extends Thread {

        @Override
        public void run() {
            System.out.println("进入线程2");

            synchronized (object) {
                flag.compareAndSet(true, false);

                try {
                    System.out.println("线程2休息8秒");
                    Thread.sleep(8000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                object.notifyAll();
            }

            System.out.println("线程1执行完成");
        }
    }

}
