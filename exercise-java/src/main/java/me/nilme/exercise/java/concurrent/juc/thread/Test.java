package me.nilme.exercise.java.concurrent.juc.thread;

/**
 * Created by nilme on 2019/11/26.
 */
public class Test {


    public static void main(String[] args) throws InterruptedException {
        Thread interruptThread = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < Integer.MAX_VALUE; i++) {
                    System.out.println("i：" + i);
                    if (this.isInterrupted()) {
                        break;
                    }
                }
            }
        };
        interruptThread.start();
        Thread.sleep(10);
        interruptThread.interrupt();
    }
}
