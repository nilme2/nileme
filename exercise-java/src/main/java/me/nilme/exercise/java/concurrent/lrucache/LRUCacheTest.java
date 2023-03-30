package me.nilme.exercise.java.concurrent.lrucache;


import java.util.Map;

/**
 * Created by nilme on 2020/3/2.
 */
public class LRUCacheTest {

    public static void main(String[] args) {

        LRUCache<String, String> cache = new LRUCache<String,String>(3);

        cache.put("1","1");
        cache.put("2","2");
        cache.put("3","3");

        cache.get("2");
        cache.get("1");
        cache.put("4","4");

        for (Map.Entry<String, String> entry : cache.entrySet()) {
            System.out.println(entry.getKey()+":"+ entry.getValue());
        }


    }
}
