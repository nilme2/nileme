package me.nilme.exercise.java.concurrent.lock;

public class Test2 {

    public static void main(String[] args) {
        ReenttrantSpinLock lock = new ReenttrantSpinLock();

        new Thread(()->{
            System.out.println("线程1：开始");
            lock.lock();
            System.out.println("线程1：获取锁");
            lock.lock();
            System.out.println("线程1：获取锁2");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            lock.unlock();
            System.out.println("线程1：释放取锁");
            lock.unlock();
            System.out.println("线程1：释放取锁2");

        }).start();

        new Thread(()->{
            System.out.println("线程2：开始");
            lock.lock();
            System.out.println("线程2：获取锁");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            lock.unlock();
            System.out.println("线程2：释放取锁");

        }).start();
    }

}
