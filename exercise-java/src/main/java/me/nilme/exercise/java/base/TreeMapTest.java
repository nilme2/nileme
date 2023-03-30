package me.nilme.exercise.java.base;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by nilme on 2020/4/18.
 */
public class TreeMapTest {

    public static void main(String[] args) {
        TreeMap<String ,String> treeMap = new TreeMap<>();
        treeMap.put("a", "a");
        treeMap.put("b", "b");

        for (Map.Entry<String, String> entry : treeMap.entrySet()) {
            System.out.println("key=" + entry.getKey()+ ", value=" + entry.getValue());
        }
    }
}
