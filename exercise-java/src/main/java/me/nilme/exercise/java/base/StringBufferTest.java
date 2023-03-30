package me.nilme.exercise.java.base;

/**
 * Created by nilme on 2020/4/18.
 */
public class StringBufferTest {

    public static void main(String[] args) {

        StringBuffer sb = new StringBuffer();
        sb.append("xxx");
        System.out.println(sb.toString());

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("xxx");
        System.out.println(stringBuilder.toString());

    }
}
