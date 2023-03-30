package me.nilme.exercise.java.reflect;

import java.lang.reflect.Method;

/**
 * Created by weizhuang on 2019-03-28.
 */
public class Reflect06GetterAndSetter {

    private String field;

    public static void main(String[] args) {

        Class<Reflect06GetterAndSetter> clazz = Reflect06GetterAndSetter.class;

        Reflect06GetterAndSetter.printGettersSetters(clazz);

    }

    public static void printGettersSetters(Class aClass) {
        Method[] methods = aClass.getMethods();

        for (Method method : methods) {
            if (isGetter(method)) System.out.println("getter: " + method);
            if (isSetter(method)) System.out.println("setter: " + method);
        }
    }

    public static boolean isGetter(Method method) {
        if (!method.getName().startsWith("get")) return false;
        if (method.getParameterTypes().length != 0) return false;
        if (void.class.equals(method.getReturnType())) return false;
        return true;
    }

    public static boolean isSetter(Method method) {
        if (!method.getName().startsWith("set")) return false;
        if (method.getParameterTypes().length != 1) return false;
        return true;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
