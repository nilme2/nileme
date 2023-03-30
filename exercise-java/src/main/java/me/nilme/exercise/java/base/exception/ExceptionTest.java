package me.nilme.exercise.java.base.exception;

/**
 * Created by nilme on 2020/4/15.
 */
public class ExceptionTest {

    public static int f(int value) {
        try {
            return value * value;
        } finally {
            if (value == 2) {
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(f(4));
    }
}
