package me.nilme.exercise.java.base;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by nilme on 2020/4/15.
 */
public class CollectionsTest {

    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();

        List<String> strings = Collections.synchronizedList(arr);

        strings.add("xxx");

    }
}
