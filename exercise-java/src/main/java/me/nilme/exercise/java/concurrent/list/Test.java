package me.nilme.exercise.java.concurrent.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nilme on 2019/11/26.
 */
public class Test {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>() {
            {
                this.add("Java");
                add("Java虚拟机");
                add("Java中文社群");
            }
        };
        for (int i = 0; i < list.size(); i++) {
            String item = list.get(i);
        }
    }
}
