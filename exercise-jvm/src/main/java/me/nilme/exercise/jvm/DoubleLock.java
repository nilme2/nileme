package me.nilme.exercise.jvm;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class DoubleLock {


    private static class Sync extends AbstractQueuedSynchronizer {

        public Sync() {
            super();
            setState(2);    //设置同步状态的值
        }

        @Override
        protected int tryAcquireShared(int arg) {
            while (true) {
                int cur = getState();
                int next = getState() - arg;
                if (compareAndSetState(cur, next)) {
                    return next;
                }
            }
        }

        @Override
        protected boolean tryReleaseShared(int arg) {
            while (true) {
                int cur = getState();
                int next = cur + arg;
                if (compareAndSetState(cur, next)) {
                    return true;
                }
            }
        }
    }
    
    private Sync sync = new Sync();
    
    public void lock() {
        sync.acquireShared(1);     
    }
    
    public void unlock() {
        sync.releaseShared(1);
    }
}
