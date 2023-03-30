package me.nilme.exercise.java.reflect;

/**
 * 反射-获取Class对象的方式
 */
public class Reflect01GetClass {

    public static void main(String[] args) throws ClassNotFoundException {
        Class c1 = Class.forName("me.nilme.exercise.reflect.Reflect01GetClass");
        System.out.println(c1.getCanonicalName());

        Class c2 = Class.forName("[D");
        System.out.println(c2.getCanonicalName());

        Class c4 = Class.forName("[I");
        System.out.println(c4.getCanonicalName());

        Class c5 = Class.forName("[F");
        System.out.println(c5.getCanonicalName());

        Class c6 = Class.forName("[B");
        System.out.println(c6.getCanonicalName());//byte[],这里是byte类型

        Class<Boolean> booleanClass = boolean.class;
        System.out.println(booleanClass.getCanonicalName());

        Class c7 = Class.forName("[Lme.nilme.exercise.Reflect01GetClass;");
        System.out.println(c7.getCanonicalName());

        Class<Reflect01GetClass> reflectClassDemo01Class = Reflect01GetClass.class;
        System.out.println(reflectClassDemo01Class.getCanonicalName());

        Reflect01GetClass reflectClassDemo01 = new Reflect01GetClass();
        Class<? extends Reflect01GetClass> c8 = reflectClassDemo01.getClass();
        System.out.println(c8.getCanonicalName());


    }

    private void method(){

    }
}