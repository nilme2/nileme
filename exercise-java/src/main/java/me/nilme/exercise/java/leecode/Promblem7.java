package me.nilme.exercise.java.leecode;

/**
 * Created by nilme on 2020/1/9.
 */
public class Promblem7 {
    public int reverse(int x) {
        boolean flag = false;

        if (x == -2147483648) {
            return 0;
        }

        if (x < 0) {
            flag = true;
            x = -x;
        }

        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            if (res > Integer.MAX_VALUE) {
                return 0;
            }
            x = x / 10;
        }

        if (flag) res = -res;
        return (int) res;
    }


    public static void main(String[] args) {

        Promblem7 promblem7 = new Promblem7();

//        int reverse = promblem7.reverse(123);
//        int reverse = promblem7.reverse(-123);
        int reverse = promblem7.reverse(120);
//        int reverse = promblem7.reverse(1534236469);
//        int reverse = promblem7.reverse(-2147483648);
//        int reverse = promblem7.reverse(-2147483647);

        System.out.println(reverse);
    }
}

