package me.nilme.exercise.java.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by nilme on 2020/4/15.
 */
public class CglibTest implements MethodInterceptor {

    Enhancer enhancer = new Enhancer();


    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println();
        Object result = proxy.invokeSuper(obj, args);
        System.out.println();
        return result;
    }

    Object getProxy(Class clazz){
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    public static void main(String[] args) {
        CglibTest cglibTest = new CglibTest();
        Target proxy = (Target)cglibTest.getProxy(Target.class);
        proxy.add();
    }
}
