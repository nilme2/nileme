package me.nilme.exercise.java.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by weizhuang on 2019-03-28.
 */
public class Reflect09Generic {

    public List<String> list;

    public String field;

    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException {

        Method method = Reflect09Generic.class.getMethod("getList", null);
        Type returnType = method.getGenericReturnType();
        System.out.println(returnType);
        if(returnType instanceof ParameterizedType){
            ParameterizedType type = (ParameterizedType) returnType;
            Type[] typeArguments = type.getActualTypeArguments();
            for(Type typeArgument : typeArguments){
                Class typeArgClass = (Class) typeArgument;
                System.out.println("typeArgClass = " + typeArgClass);
            }
        }

        Method method2 = Reflect09Generic.class.getMethod("getField", null);
        Type returnType2 = method2.getGenericReturnType();
        System.out.println(returnType2);

        method = Reflect09Generic.class.getMethod("setList", List.class);
        Type[] genericParameterTypes = method.getGenericParameterTypes();
        for(Type genericParameterType : genericParameterTypes){
            if(genericParameterType instanceof ParameterizedType){
                ParameterizedType aType = (ParameterizedType) genericParameterType;
                Type[] parameterArgTypes = aType.getActualTypeArguments();
                for(Type parameterArgType : parameterArgTypes){
                    Class parameterArgClass = (Class) parameterArgType;
                    System.out.println("parameterArgClass = " + parameterArgClass);
                }
            }
        }

        Field field = Reflect09Generic.class.getField("list");
        Type genericFieldType = field.getGenericType();
        if(genericFieldType instanceof ParameterizedType){
            ParameterizedType aType = (ParameterizedType) genericFieldType;
            Type[] fieldArgTypes = aType.getActualTypeArguments();
            for(Type fieldArgType : fieldArgTypes){
                Class fieldArgClass = (Class) fieldArgType;
                System.out.println("fieldArgClass = " + fieldArgClass);
            }
        }


    }


    public void setList(List<String> list) {
        this.list = list;
    }

    public List<String> getList() {
        return list;
    }

    public String getField() {
        return field;
    }
}
