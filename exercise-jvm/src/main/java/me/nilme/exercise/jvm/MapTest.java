package me.nilme.exercise.jvm;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.HashMap;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author weizhuang
 * Created on 2019-04-04.
 */
public class MapTest {
    public static void main(String[] args) {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("test-thread-%d").build();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(1000, 1000, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(100000), new ThreadPoolExecutor.AbortPolicy());

        HashMap<String, String> map = new HashMap<>();
//        ConcurrentHashMap<String, String> map2 = new ConcurrentHashMap<>();

        map.put("aaa", "aaa");
        map.put("bbb", "bbb");
        map.put("ccc", "ccc");

        AtomicBoolean flag = new AtomicBoolean(true);

        for (int i = 0; i < 10000; i++) {
            Mythread mythread = new Mythread(map, flag, "name" + i);
            pool.execute(mythread);
        }
        pool.shutdown();
    }


    public static class Mythread implements Runnable {

        private HashMap<String, String> map;

        private AtomicBoolean flag;

        private String name;

        public Mythread(HashMap<String, String> map, AtomicBoolean flag, String name) {
            this.map = map;
            this.name = name;
            this.flag = flag;
        }

        @Override
        public void run() {
            map.put("xxxx", "xxxx");
            if (map.get("aaa") == null) {
                System.out.println("果然出现空值了");
                flag.compareAndSet(true, false);
            }
//            if (!flag.get() || map.get("aaa") !=null){
//                System.out.println("其他线程还是可以取到值的");
//                flag.compareAndSet(false, true);
//            }
        }
    }

}
