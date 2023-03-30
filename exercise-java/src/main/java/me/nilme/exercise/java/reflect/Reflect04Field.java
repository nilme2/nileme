package me.nilme.exercise.java.reflect;

import java.lang.reflect.Field;

/**
 * Created by weizhuang on 2019-03-28.
 */
public class Reflect04Field {

    private String field1;
    public String field2;

    public static String staticField;

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        Class<Reflect04Field> clazz = Reflect04Field.class;

        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println("-------------");

        Field field2 = clazz.getField("field2");
        System.out.println(field2);
        System.out.println(field2.getName());
        System.out.println(field2.getType());

        try {
            Field field1 = clazz.getField("field1");
            System.out.println(field1);
        }catch (Exception e){
            System.out.println("私有字段无法获取");
        }

        Reflect04Field reflect04Field = new Reflect04Field();

        //设置值
        field2.set(reflect04Field, "value");

        //获取值
        Object o = field2.get(reflect04Field);
        System.out.println(o);

        Field staticField = clazz.getField("staticField");

        Object o1 = staticField.get(null);
        System.out.println(o1);

        staticField.set(null, "staticField");
        System.out.println(o1);

        Object o2 = staticField.get(null);
        System.out.println(o2);

    }
}
