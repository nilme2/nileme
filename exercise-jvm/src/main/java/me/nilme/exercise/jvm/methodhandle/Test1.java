package me.nilme.exercise.jvm.methodhandle;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;

/**
 * @author weizhuang
 * Created on 2019-05-16.
 */
public class Test1 {


    //添加vm参数    -XX:+ShowHiddenFrames
    public static void main(String[] args) throws Throwable {
        // 获取方法句柄的不同方式
        MethodHandles.Lookup l = Foo.lookup(); // 具备 Foo 类的访问权限
        Method m = Foo.class.getDeclaredMethod("bar", Object.class);
        MethodHandle mh0 = l.unreflect(m);

        MethodType t = MethodType.methodType(void.class, Object.class);
        MethodHandle mh1 = l.findStatic(Foo.class, "bar", t);

        mh0.invokeExact(new Object());

        System.out.println(mh0);
        System.out.println(mh1);
        System.out.println(mh0==mh1);
        System.out.println(mh0.equals(mh1));

        mh0.invoke(new Object());

        Class<?> clazz = Class.forName("me.nilme.exercise.jvm.methodhandle.Foo");

    }
}
