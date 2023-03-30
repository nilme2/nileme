package me.nilme.exercise.java.proxy.doublemetch.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * @author weizhuang
 * 学习博客地址
 * https://www.cnblogs.com/lxyit/p/9328294.html
 * Created on 2019-09-11.
 */
public class Main {
    public static void main(String[] args) {

        //Enhancer是生成代理类的工厂
        Enhancer enhancer = new Enhancer();
        //设置代理的超类，即被代理对象
        enhancer.setSuperclass(EchoServiceImpl.class);
        //设置拦截方法
        enhancer.setCallback(new EchoServiceInterceptor());
        //生成代理对象
        EchoServiceImpl echoService = (EchoServiceImpl) enhancer.create();

        echoService.echo("test");

    }
}
