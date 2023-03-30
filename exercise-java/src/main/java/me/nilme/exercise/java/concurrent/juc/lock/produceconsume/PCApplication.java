package me.nilme.exercise.java.concurrent.juc.lock.produceconsume;

public class PCApplication {

    public static void main(String[] args) {
        PCService service = new PCService();
        Runnable produce = new MyThreadProduce(service);
        Runnable consume = new MyThreadConsume(service);
        new Thread(produce, "生产者  ").start();
        new Thread(consume, "消费者  ").start();
    }
}