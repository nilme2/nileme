package me.nilme.exercise.java.reflect;

import java.lang.reflect.Array;

/**
 * Created by weizhuang on 2019-03-28.
 */
public class Reflect10Array {

    public static void main(String[] args) {
        int[] intArray = (int[])Array.newInstance(int.class, 3);

        System.out.println(intArray.length);

        Array.set(intArray, 0, 123);
        Array.set(intArray, 1, 456);
        Array.set(intArray, 2, 789);

        System.out.println("intArray[0] = " + Array.get(intArray, 0));
        System.out.println("intArray[1] = " + Array.get(intArray, 1));
        System.out.println("intArray[2] = " + Array.get(intArray, 2));

        Class stringArrayClass = Array.newInstance(String.class, 0).getClass();
        System.out.println("is array: " + stringArrayClass.isArray());

        String[] strings = new String[3];
        Class clazz = strings.getClass();
        Class stringArrayComponentType = clazz.getComponentType();
        System.out.println(stringArrayComponentType);

    }
}
