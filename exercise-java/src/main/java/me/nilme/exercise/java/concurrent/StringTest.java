package me.nilme.exercise.java.concurrent;

/**
 * @author weizhuang
 * Created on 2019-06-05.
 */
public class StringTest {

    public static void main(String[] args) {

        String str1 = new StringBuilder().append("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);
        String str3 = new StringBuilder().append("ja").append("va").toString();

        System.out.println(str3.intern() == str3);
        String str2 = new StringBuilder().append("ja").append("va").append("va").append("va").toString();
        System.out.println(str2.intern() == str2);


    }
}
