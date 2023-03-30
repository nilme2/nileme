package me.nilme.exercise.java.concurrent.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by nilme on 2019/11/21.
 */
public class Test3 {


    public static void main(String[] args) {

        StringBuffer sb =new StringBuffer();

        System.out.println(3 * 0.1 == 0.30000000000000001);

        myfor:for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                System.out.println("J:" + j);
                if (j == 10) {
                    // 跳出多重循环
                    break myfor;
                }
            }
        }
    }

}
