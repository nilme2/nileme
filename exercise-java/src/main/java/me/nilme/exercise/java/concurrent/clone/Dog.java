package me.nilme.exercise.java.concurrent.clone;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by nilme on 2019/11/25.
 */
public class Dog implements Cloneable {

    public String name;

    public Integer age;

    private HashMap<Integer, Integer> map = new HashMap<>();

    private HashSet<String> set = new HashSet<>();

    public DogChild dogChild;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void test(){

        set.add("xxx");

    }


}
