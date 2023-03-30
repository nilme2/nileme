package me.nilme.exercise.java.concurrent.juc.thread;

/**
 * Created by nilme on 2020/3/23.
 */
public class ThreadInterruptTest {

    public static void main(String[] args) throws InterruptedException {
//        ThreadInterruptTest.test1();
//        ThreadInterruptTest.test2();
//        ThreadInterruptTest.test3();
//        ThreadInterruptTest.test4();
        ThreadInterruptTest.test5();
//        ThreadInterruptTest.test6();

    }

    /**
     * 发出了线程中断，但是没有响应线程中断，所以没有用，线程还是继续执行
     */
    private static void test1() {
        Thread thread = new Thread(() -> {
            while (true) {
                System.out.println("aaa");
                Thread.yield();
                System.out.println("bbb");
            }
        });
        thread.start();
        thread.interrupt();
    }

    /**
     * 发出的线程中断，也响应了，所以有效
     */
    private static void test2() {
        Thread thread = new Thread(() -> {
            while (true) {
                Thread.yield();

                // 响应中断
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Java技术栈线程被中断，程序退出。");
                    return;
                }
            }
        });
        thread.start();
        thread.interrupt();
    }

    private static void test3() throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                // 响应中断
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Java技术栈线程被中断，程序退出。");
                    return;
                }

                try {
                    //sleep后会清除中断标记，所以程序继续运行
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    System.out.println("Java技术栈线程休眠被中断，程序退出。");
                }
            }
        });
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
    }

    private static void test4() throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                // 响应中断
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Java技术栈线程被中断，程序退出。");
                    return;
                }

                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    System.out.println("Java技术栈线程休眠被中断，程序退出。");
                    Thread.currentThread().interrupt();
                }
            }
        });
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
    }

    private static void test5() {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(0);
                System.out.println("任务执行中1");
                Thread.sleep(0);
                System.out.println("任务执行中2");
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("线程中断");
                return;
            }
        });
        thread.start();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        thread.interrupt();
    }

    /**
     * 如果sleep传入了一个负数，会直接抛出中断异常
     */
    private static void test6() {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(-1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }

}
