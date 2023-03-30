package me.nilme.exercise.java.concurrent;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author weizhuang
 * Created on 2019-05-15.
 */
public class ConditionWaitAndSignal {

    public static final Lock lock = new ReentrantLock();

    public static Condition condition = lock.newCondition();

    public static AtomicBoolean flag = new AtomicBoolean(false);

    public static void main(String[] args) throws InterruptedException {

        ConditionWaitAndSignal cwa = new ConditionWaitAndSignal();

        new Thread(()->{
            try {
                cwa.conditionAWait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                cwa.conditionSignal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

    }

    //等待线程的典型模式
    public void conditionAWait() throws InterruptedException {
        lock.lock();    //获取锁
        Thread.sleep(3000);
        System.out.println("等待线程---获取锁");
        try {
            while (!flag.get()) {
                System.out.println("等待线程---处于等待状态");
                condition.await();  //使线程处于等待状态
                System.out.println("等待线程---结束等待");
            }
            System.out.println("等待线程---符合条件后执行");
        } finally {
            lock.unlock();
            System.out.println("等待线程---释放锁");
        }
    }

    //通知线程的典型模式
    public void conditionSignal() throws InterruptedException {
        lock.lock();    //获取锁
        System.out.println("通知线程---获取锁");
        try {
            System.out.println("通知线程---休息5秒");
            Thread.sleep(5000);
            System.out.println("通知线程---修改状态");
            flag.compareAndSet(false, true);
            System.out.println("通知线程---signalAll");
            condition.signalAll();  //唤醒处于等待状态的线程
        } finally {
            lock.unlock();
            System.out.println("通知线程---释放锁");
        }
    }


}
