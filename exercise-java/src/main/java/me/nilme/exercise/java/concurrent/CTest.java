package me.nilme.exercise.java.concurrent;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author weizhuang
 * Created on 2019-06-26.
 */
public class CTest {

    static final int MAXIMUM_CAPACITY = 1 << 30;


    public static void main(String[] args) {
        int a = 1;
        HashMap<String, String>  map  = new HashMap(3);
        map.put("1","2");

        for (Map.Entry<String, String> stringStringEntry : map.entrySet()) {
            
        }

        System.out.println("xxx");

        int i = tableSizeFor(5);
        System.out.println(i);

        System.out.println(Math.ceil(10.3));

    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;//4=0100
        n = n | n >>> 1; // 0100 | 0010  = 0110
        n |= n >>> 2;// 0110 | 0001 = 0111
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

}
