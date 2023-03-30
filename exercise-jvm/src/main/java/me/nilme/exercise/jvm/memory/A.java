package me.nilme.exercise.jvm.memory;

/**
 * @author weizhuang
 * Created on 2019-05-20.
 */
public class A {
    long a = 1;
    private int b = 2;

    public A() {
    }

    public A(long a, int b) {

        System.out.println("a=" + a);
    }

    public void printA(){
        System.out.println("a=" + a);
    }
}
