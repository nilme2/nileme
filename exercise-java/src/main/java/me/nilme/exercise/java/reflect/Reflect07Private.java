package me.nilme.exercise.java.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by weizhuang on 2019-03-28.
 */
public class Reflect07Private {

    private String privateString;

    public Reflect07Private(String privateString) {
        this.privateString = privateString;
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        Reflect07Private privateObject = new Reflect07Private("The Private Value");

        Class<Reflect07Private> clazz = Reflect07Private.class;

        Field privateStringField = clazz.getDeclaredField("privateString");
        privateStringField.setAccessible(true);
        String fieldValue = (String) privateStringField.get(privateObject);
        System.out.println("fieldValue = " + fieldValue);

        Method privateStringMethod = clazz.getDeclaredMethod("getPrivateString", null);
        privateStringMethod.setAccessible(true);
        String returnValue = (String) privateStringMethod.invoke(privateObject, null);
        System.out.println("returnValue = " + returnValue);

    }


    private String getPrivateString() {
        return privateString;
    }
}
