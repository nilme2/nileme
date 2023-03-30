package me.nilme.exercise.java.reflect.jksj;

import java.lang.reflect.Method;

/**
 * @author weizhuang
 * Created on 2019-05-14.
 */
public class TestV4 {


    public static void target(int i) {
        // 空方法
    }

    public static void target1(int i) {
    }

    public static void target2(int i) {
    }

    public static void main(String[] args) throws Exception {
        Class<?> klass = Class.forName("me.nilme.exercise.reflect.jksj.TestV4");
        Method method = klass.getMethod("target", int.class);
        method.setAccessible(true);  // 关闭权限检查
//        Method method1 = polluteProfile();

//        System.out.println(method1 == method);

        long current = System.currentTimeMillis();
        for (int i = 1; i <= 2_000_000_000; i++) {
            if (i % 100_000_000 == 0) {
                long temp = System.currentTimeMillis();
                System.out.println(temp - current);
                current = temp;
            }

            method.invoke(null, 128);
        }
    }

    public static Method polluteProfile() throws Exception {
        Method method1 = TestV4.class.getMethod("target", int.class);
        Method method2 = TestV4.class.getMethod("target", int.class);
        for (int i = 0; i < 2000; i++) {
            method1.invoke(null, 0);
            method2.invoke(null, 0);
        }

        return method1;
    }

}
