package me.nilme.exercise.java.proxy.cglib2;

public class EchoServiceImpl implements EchoService {

    public void echo(String message) {
        System.out.println(message);
    }

    public void print(String message) {
        System.out.println(message);
    }

    public int test() {
        return 1;
    }

    public final void finalTest() {
        System.out.println("I am final method.");
    }
}