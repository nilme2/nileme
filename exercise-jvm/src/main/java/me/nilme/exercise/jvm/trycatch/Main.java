package me.nilme.exercise.jvm.trycatch;

/**
 * @author weizhuang
 * Created on 2019-05-20.
 */
public class Main {
    public static void main(String[] args) {
        int i = 0;
        try {
            int a = i / 0;
        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            throw new RuntimeException();
        }

    }
}
