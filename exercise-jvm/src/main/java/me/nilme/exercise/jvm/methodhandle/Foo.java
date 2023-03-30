package me.nilme.exercise.jvm.methodhandle;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;

/**
 * @author weizhuang
 * Created on 2019-05-16.
 */
public class Foo {

    private void bar(Object o) {
//        System.out.println("Foo.bar");
    }
    public static MethodHandles.Lookup lookup() {
        return MethodHandles.lookup();
    }

    public static void main(String[] args) throws Throwable {
        MethodHandles.Lookup l = MethodHandles.lookup();
        MethodType t = MethodType.methodType(void.class, Object.class);
        MethodHandle mh = l.findVirtual(Foo.class, "bar", t);

//        Method m = Foo.class.getDeclaredMethod("bar", Object.class);
//        MethodHandle mh = l.unreflect(m);

        long current = System.currentTimeMillis();
        for (int i = 1; i <= 2_000_000_000; i++) {
            if (i % 100_000_000 == 0) {
                long temp = System.currentTimeMillis();
                System.out.println(temp - current);
                current = temp;
            }
            mh.invokeExact(new Foo(), new Object());
        }
    }
}
