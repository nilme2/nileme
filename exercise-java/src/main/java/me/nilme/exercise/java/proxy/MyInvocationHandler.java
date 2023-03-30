package me.nilme.exercise.java.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by nilme on 2020/4/15.
 */
public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    MyInvocationHandler(Object target){
        super();
        this.target = target;
    }


    public Object getProxy(){
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), target.getClass().getInterfaces(), this);
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("before");
        method.invoke(target, args);
        System.out.println("after");

        return null;
    }

    public static void main(String[] args) {
        UserService service = new UserServiceImpl();
        MyInvocationHandler handler = new MyInvocationHandler(service);
        UserService proxy = (UserService) handler.getProxy();
        proxy.add();

    }
}
