package me.nilme.exercise.java.concurrent.juc.lock.produceconsume;

import me.nilme.exercise.java.concurrent.juc.lock.produceconsume.PCService;

public class MyThreadConsume implements Runnable{

    private PCService service;

    public MyThreadConsume(PCService service) {
        this.service = service;
    }

    @Override
    public void run() {
        for (;;) {

            String addf = "ffd";
            service.consume();

            String aa  = "fdf";
            String join = String.join("ff", "ffdf");


        }
    }    
}