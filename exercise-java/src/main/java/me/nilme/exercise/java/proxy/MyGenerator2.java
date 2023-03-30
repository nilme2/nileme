package me.nilme.exercise.java.proxy;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;

import java.net.URL;

/**
 * Created by weizhuang on 2019-03-29.
 */
public class MyGenerator2 {

    public static void main(String[] args) throws Exception {
        ClassPool pool = ClassPool.getDefault();
        //创建Programmer类
        CtClass cc = pool.makeClass("com.samples.Programmer");
        //定义code方法
        CtMethod method = CtNewMethod.make("public void code(){}", cc);
        //插入方法代码
        method.insertBefore("System.out.println(\"I'm a Programmer,Just Coding.....\");");
        cc.addMethod(method);

        URL resource = MyGenerator.class.getClassLoader().getResource("clazz");
        //保存生成的字节码
        cc.writeFile(resource.getPath() + "/MyGenerator2.class");
    }
}
