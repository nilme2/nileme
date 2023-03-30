package me.nilme.exercise.java.concurrent.map;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by nilme on 2019/12/22.
 */
public class HashMapTest {


    public static void main(String[] args) {

        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        map.put("1",1);


        Integer integer = map.get("1");

        int a = 1;
        int b = 2;

        if( (a = 2) ==b){
            System.out.println("xxx");
        }

        HashMap<String,String > map2 = new HashMap<>();


    }

}
