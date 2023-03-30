package me.nilme.exercise.java.concurrent;

/**
 * @author weizhuang
 * Created on 2019/10/25.
 */
public class CloneTest implements Cloneable {

    public static void main(String[] args) throws CloneNotSupportedException {

        CloneTest cloneTest = new CloneTest();
        Object clone = cloneTest.clone();

        System.out.println(clone);
    }


}
