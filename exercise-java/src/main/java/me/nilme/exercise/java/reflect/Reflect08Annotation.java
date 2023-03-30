package me.nilme.exercise.java.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by weizhuang on 2019-03-28.
 */

@MyAnnotation(name = "name", value = "value")
public class Reflect08Annotation {

    @MyAnnotation(name = "name", value = "value")
    public String field;

    public static void main(String[] args) throws NoSuchMethodException {

        Class<Reflect08Annotation> calzz = Reflect08Annotation.class;
        Annotation[] annotations = calzz.getAnnotations();

        for (Annotation annotation : annotations) {
            if (annotation instanceof MyAnnotation) {
                MyAnnotation myAnnotation = (MyAnnotation) annotation;
                System.out.println("name: " + myAnnotation.name());
                System.out.println("value: " + myAnnotation.value());
            }
        }

        MyAnnotation annotation = calzz.getAnnotation(MyAnnotation.class);
        System.out.println("name: " + annotation.name());
        System.out.println("value: " + annotation.value());


        Method getField = calzz.getMethod("setField", new Class[]{String.class});
        MyAnnotation annotation1 = getField.getAnnotation(MyAnnotation.class);
        System.out.println("name: " + annotation.name());
        System.out.println("value: " + annotation.value());

        Annotation[] fieldAnnotations = getField.getAnnotations();
        System.out.println(Arrays.toString(fieldAnnotations));

        Annotation[][] parameterAnnotations = getField.getParameterAnnotations();
        Class[] parameterTypes = getField.getParameterTypes();

        int i=0;
        for(Annotation[] annotations3 : parameterAnnotations){
            Class parameterType = parameterTypes[i++];
            for(Annotation annotation3 : annotations){
                if(annotation instanceof MyAnnotation){
                    MyAnnotation myAnnotation = annotation;
                    System.out.println("param: " + parameterType.getName());
                    System.out.println("name : " + myAnnotation.name());
                    System.out.println("value: " + myAnnotation.value());
                }
            }
        }


    }

    public String getField() {
        return field;
    }

    public void setField(@MyAnnotation(name="aName", value="aValue") String field) {
        this.field = field;
    }
}
