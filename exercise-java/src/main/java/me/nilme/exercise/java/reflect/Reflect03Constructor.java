package me.nilme.exercise.java.reflect;


import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Reflect03Constructor {

    private String fieldName1;
    public String fieldName12;
    private static String fieldName2;
    private static final String fieldName3 = "getFieldName3";

    public Reflect03Constructor(@Deprecated String fieldName1, String fieldName12) {
        this.fieldName1 = fieldName1;
        this.fieldName12 = fieldName12;
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<Reflect03Constructor> clazz = Reflect03Constructor.class;

        Constructor<?>[] constructors = clazz.getConstructors();

        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }

        Constructor<Reflect03Constructor> constructor = clazz.getConstructor(new Class[]{String.class, String.class});

        Class<?>[] parameterTypes = constructor.getParameterTypes();

        for (Class<?> parameterType : parameterTypes) {
            System.out.println(parameterType);
        }

        Annotation[][] parameterAnnotations = constructor.getParameterAnnotations();

        for (Annotation[] parameterAnnotation : parameterAnnotations) {
            for (Annotation annotation : parameterAnnotation) {
                System.out.println(annotation);
            }
        }

        Reflect03Constructor reflectClassDemo03 = constructor.newInstance("value1", "value2");

        reflectClassDemo03.printInfo();
    }

    public void printInfo(){

        System.out.println("printInfo");

    }

}