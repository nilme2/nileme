package me.nilme.exercise.java.concurrent.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReenterLockCondition implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();
    public static Condition condition = lock.newCondition();
    @Override
    public void run() {
        lock.lock();
        System.out.println("子线程lock");
        try {
            condition.await();
            System.out.println("子线程继续执行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
            System.out.println("子线程unlock");
        }
    }
    public static void main(String[] args) throws InterruptedException {
        ReenterLockCondition tl = new ReenterLockCondition();
        Thread t1 = new Thread(tl);
        t1.start();
        Thread.sleep(3000);
        System.out.println("主线程执行玩");
        lock.lock();
        System.out.println("主线程lock");
        condition.signal();
        System.out.println("主线程signal");
        lock.unlock();
        System.out.println("主线程unlock");
    }
}