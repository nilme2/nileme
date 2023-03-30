package me.nilme.exercise.java.concurrent.list;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by nilme on 2019/11/26.
 */
public class Test2 {

    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

        queue.add(1);
        queue.add(12);
        queue.add(13);
        queue.add(14);

        while(queue.size()>0){
            System.out.println(queue.poll());
        }

    }
}
