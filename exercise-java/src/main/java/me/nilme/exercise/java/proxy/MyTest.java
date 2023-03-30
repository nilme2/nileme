package me.nilme.exercise.java.proxy;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;

public class MyTest {

    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //读取本地的class文件内的字节码，转换成字节码数组
        File file = new File(".");

        MyTest myTest = new MyTest();

        URL resource = myTest.getClass().getClassLoader().getResource("clazz/Programmer.class");

        InputStream input = new FileInputStream(resource.getPath());
        byte[] result = new byte[1024];

        int count = input.read(result);
        // 使用自定义的类加载器将 byte字节码数组转换为对应的class对象
        MyClassLoader loader = new MyClassLoader();
        Class clazz = loader.defineMyClass(result, 0, count);

        //测试加载是否成功，打印class 对象的名称
        System.out.println(clazz.getCanonicalName());

        //实例化一个Programmer对象
        Object o = clazz.newInstance();

        Method method = clazz.getMethod("code", null);

        method.invoke(o, null);

    }
}