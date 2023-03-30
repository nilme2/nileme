package me.nilme.exercise.java.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by weizhuang on 2019-03-28.
 */
public class Reflect05Method {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Class<Reflect05Method> clazz = Reflect05Method.class;
        Method method = clazz.getMethod("helloWorld", new Class[]{String.class});

        System.out.println(method);

        Class[] parameterTypes = method.getParameterTypes();
        for (Class parameterType : parameterTypes) {
            System.out.println(parameterType);
        }

        System.out.println(method.getReturnType());

        method.invoke(new Reflect05Method(), "nilme");


        Method staticHelloWorld = clazz.getMethod("staticHelloWorld", new Class[]{String.class});
        Object nilme = staticHelloWorld.invoke(null, "nilme");
        System.out.println(nilme);

    }


    public String helloWorld(String name){
        System.out.println(name + ":" + "Hello World!!!");
        return "Return Hello World";
    }

    public static String staticHelloWorld(String name){
        System.out.println(name + ":" + "static Hello World!!!");
        return "Return static Hello World";
    }
}
