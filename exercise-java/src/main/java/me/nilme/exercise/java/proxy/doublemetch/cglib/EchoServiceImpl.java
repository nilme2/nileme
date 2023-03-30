package me.nilme.exercise.java.proxy.doublemetch.cglib;

public class EchoServiceImpl {

    public void echo(String message) {
        System.out.println("echo:" + message);
        this.print("内部调用+" + message);
    }

    public void print(String message) {
        System.out.println("print:" + message);
    }
}