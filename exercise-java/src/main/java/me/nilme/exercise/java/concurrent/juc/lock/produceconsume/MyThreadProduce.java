package me.nilme.exercise.java.concurrent.juc.lock.produceconsume;

import me.nilme.exercise.java.concurrent.juc.lock.produceconsume.PCService;

/**
 * 生产者线程
 * @author lixiaoxi
 *
 */
public class MyThreadProduce implements Runnable{

    private PCService service;

    public MyThreadProduce(PCService service) {
        this.service = service;
    }

    @Override
    public void run() {
        for (;;) {
            service.produce();
        }
    }

}