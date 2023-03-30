package me.nilme.exercise.java.concurrent.jiaotidaying;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by nilme on 2020/4/16.
 */
public class OldEvenTest2 {

    private static int count = 0;

    public static void main(String[] args) {
        method2();
    }

    private static void method2() {
        Lock lock = new ReentrantLock();
        Condition evenCondition = lock.newCondition();
        Condition oldCondition = lock.newCondition();
        //偶数线程
        new Thread(() -> {
            while (count <= 100) {
                try {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + ":" + count);
                    count++;
                    //唤醒奇数线程
                    oldCondition.signal();

                    //打印出100后，就不再等待
                    if (count <= 100) {
                        evenCondition.await();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }, "偶数").start();

        //奇数线程
        new Thread(() -> {
            while (count <= 100) {
                try {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + ":" + count);
                    count++;
                    //唤醒偶数线程
                    evenCondition.signal();

                    oldCondition.await();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }, "奇数").start();
    }
}
