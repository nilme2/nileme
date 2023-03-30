package me.nilme.exercise.java.proxy.jvm;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class AnimalProxy implements InvocationHandler {
    private Object target; // 代理对象
    public Object getInstance(Object target) {
        this.target = target;
        // 取得代理对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用前");
        Object result = method.invoke(target, args); // 方法调用
        System.out.println("调用后");
        return result;
    }
}