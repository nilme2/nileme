package me.nilme.exercise.java.concurrent.lock;

public class Test {

    public static void main(String[] args) {
        SpinLock lock = new SpinLock();

        new Thread(()->{
            System.out.println("线程1：开始");
            lock.lock();
            System.out.println("线程1：获取锁");

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            lock.unlock();
            System.out.println("线程1：释放取锁");

        }).start();

        new Thread(()->{
            System.out.println("线程2：开始");
            lock.lock();
            System.out.println("线程2：获取锁");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            lock.unlock();
            System.out.println("线程2：释放取锁");

        }).start();
    }

}
