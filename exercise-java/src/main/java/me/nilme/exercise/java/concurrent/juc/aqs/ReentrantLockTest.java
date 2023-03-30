package me.nilme.exercise.java.concurrent.juc.aqs;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by nilme on 2020/2/17.
 */
public class ReentrantLockTest {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock(true);
        try {


            lock.lock();

        } finally {
            lock.unlock();
        }




    }
}
