package me.nilme.exercise.java.base.singleton;

import com.sun.org.apache.bcel.internal.classfile.InnerClass;

/**
 * Created by nilme on 2020/4/20.
 */
public class Singleton2 {
    private static Singleton2 singleton;

    private Singleton2(){

    }

    public static class InnerClass{
        private final static Singleton2 singleton = new Singleton2();
    }

    public static final Singleton2 getInstance(){
        return InnerClass.singleton;
    }

}
