package me.nilme.exercise.java.concurrent.lock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 可重入的自旋锁
 */
public class ReenttrantSpinLock {

    private AtomicReference<Thread> cas = new AtomicReference<>();

    private AtomicInteger count = new AtomicInteger(0);

    public void lock(){
        Thread current = Thread.currentThread();
        if (current == cas.get()){
            count.incrementAndGet();
            return ;
        }

        while (!cas.compareAndSet(null,current)){
            //Do nothing
        }
    }

    public void unlock(){
        Thread current = Thread.currentThread();
        if (current == cas.get()){
            if (count.get()>0){
                count.decrementAndGet();
            }else{
                cas.compareAndSet(current,null);
            }
        }
    }
}
