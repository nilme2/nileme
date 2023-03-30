package me.nilme.exercise.java.concurrent.hashmap;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by nilme on 2020/3/2.
 */
public class ConcurrentHashMapTest {


    public static void main(String[] args) {
        ConcurrentHashMap map = new ConcurrentHashMap();

        map.put("1","1");
        map.get("1");

    }
}
