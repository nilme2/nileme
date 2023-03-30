package me.nilme.exercise.jvm;

/**
 * Created by weizhuang on 2019-04-01.
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        boolean x = true;

        if (x) {
            System.out.println("吃了");
        }

        if (true == x) {
            System.out.println("真吃了");
        }

        System.out.println(-0.0F == +0.0F);

        float nan = 0.0F / 0.0F;

        System.out.println(nan);

        System.out.println(nan < 1.0F);
        System.out.println(nan > 1.0F);

        System.out.println(nan != 1.0F);
        System.out.println(nan == 1.0F);
        System.out.println(nan == nan);


    }
}
