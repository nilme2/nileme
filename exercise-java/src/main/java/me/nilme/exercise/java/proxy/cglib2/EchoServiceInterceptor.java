package me.nilme.exercise.java.proxy.cglib2;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class EchoServiceInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before invoking!");
        Object object = methodProxy.invokeSuper(o, objects);
        System.out.println("after invoking!");
        return object;
    }
}