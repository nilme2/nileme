package me.nilme.exercise.java.concurrent.hashmap;

import java.util.*;

/**
 * Created by nilme on 2019/11/21.
 */
public class Test2 {

    private static HashMap<Integer, String> map = new HashMap<>(2, 0.75f);

    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(1, 2, 3, 4);

        integers.add(5);

        integers.forEach(System.out::println);

        map.put(5, "C");

        new Thread("Thread1") {
            public void run() {
                map.put(7, "B");
                System.out.println(map);
            };
        }.start();
        new Thread("Thread2") {
            public void run() {
                map.put(3, "A");
                System.out.println(map);
            };
        }.start();
    }
}
