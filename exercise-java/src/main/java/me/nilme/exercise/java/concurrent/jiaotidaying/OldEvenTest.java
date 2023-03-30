package me.nilme.exercise.java.concurrent.jiaotidaying;

/**
 * Created by nilme on 2020/4/16.
 */
public class OldEvenTest {


    public static void main(String[] args) {
        Object moniter = new Object();
       new Thread( new OldPrintThread(moniter)).start();
       new Thread( new EvenPrintThread(moniter)).start();
    }


    public static class OldPrintThread implements Runnable {
        private Object moniter;
        private int value = 1;

        public OldPrintThread(Object moniter) {
            this.moniter = moniter;
        }

        @Override
        public void run() {
            while (value < 100) {
                synchronized (moniter) {
                    System.out.println(value);
                    value = value + 2;
                    moniter.notify();
                    try {
                        moniter.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static class EvenPrintThread implements Runnable {
        private Object moniter;
        private int value = 2;

        public EvenPrintThread(Object moniter) {
            this.moniter = moniter;
        }

        @Override
        public void run() {
            while (value < 100) {
                synchronized (moniter) {
                    System.out.println(value);
                    value = value + 2;
                    moniter.notify();
                    try {
                        if (value <= 100) {
                            moniter.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
