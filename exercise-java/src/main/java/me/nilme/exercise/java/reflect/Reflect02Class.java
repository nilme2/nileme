package me.nilme.exercise.java.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

@MyAnnotation(name = "test", value = "value")
public class Reflect02Class {

    private String fieldName1;
    public String fieldName12;
    private static String fieldName2;
    private static final String fieldName3 = "getFieldName3";

    public static void main(String[] args) throws ClassNotFoundException {
        Class c1 = Class.forName("me.nilme.exercise.reflect.Reflect02Class");
        System.out.println(c1.getCanonicalName());
        System.out.println(c1.getModifiers());
        System.out.println(c1.getPackage());
        System.out.println(c1.getSuperclass());

        System.out.println(">>>>>>>>>>>>>Reflect02Class.annotation>>>>>>>>>>>>>");
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
        System.out.println(">>>>>>>>>>>>>end>>>>>>>>>>>>>");


        System.out.println(">>>>>>>>>>>>>Reflect02Class.fields>>>>>>>>>>>>>");
        Field[] fields = c1.getFields();
        Field[] declaredFields = c1.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("----");
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }
        System.out.println(">>>>>>>>>>>>>end>>>>>>>>>>>>>");

        Class<?>[] interfaces = HashMap.class.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface);
        }

        Constructor[] hashmapConstructors = HashMap.class.getConstructors();
        System.out.println("HashMap.class.constructors----------------");
        for (Constructor constructor : hashmapConstructors) {
            System.out.println(constructor);
        }
        System.out.println("HashMap.class.constructors----------------");

        Class c3 = Class.forName("[[Ljava.lang.String;");
        System.out.println(c3.getCanonicalName());

        System.out.println("----------------------------");

        Class stringArrayClass = Array.newInstance(String.class, 0).getClass();
        System.out.println("getName=" + stringArrayClass.getName());
        System.out.println("getSimpleName=" + stringArrayClass.getSimpleName());
        System.out.println("getModifiers=" + stringArrayClass.getModifiers());
        System.out.println("getPackage=" + stringArrayClass.getPackage());//null, 数组类型的package为null

        Constructor[] constructors = stringArrayClass.getConstructors();
        System.out.println("constructors----------------");
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        System.out.println("constructors----------------");


        System.out.println(stringArrayClass.getCanonicalName());
        System.out.println(stringArrayClass.getComponentType());
        System.out.println("is array: " + stringArrayClass.isArray());

        System.out.println(">>>>>>>>>>>>>methods>>>>>>>>>>>>>");
        Method[] methods = Reflect02Class.class.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println(">>>>>>>>>>>>>end>>>>>>>>>>>>>");

    }

    private void method(){

    }
}