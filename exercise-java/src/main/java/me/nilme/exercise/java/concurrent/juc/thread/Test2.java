package me.nilme.exercise.java.concurrent.juc.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by nilme on 2020/1/9.
 */
public class Test2 {

    private static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        lock.lock();

        try {

        } finally {
            lock.unlock();
        }
    }
}
