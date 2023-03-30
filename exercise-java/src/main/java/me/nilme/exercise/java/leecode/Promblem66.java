package me.nilme.exercise.java.leecode;

import java.util.Arrays;

/**
 * Created by nilme on 2020/1/9.
 */
public class Promblem66 {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            if (digits[i] == 10) {
                digits[i] = 0;
            } else {
                return digits;
            }
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        Promblem66 promblem = new Promblem66();
        System.out.println(Arrays.toString(promblem.plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(promblem.plusOne(new int[]{9, 9, 9})));
        System.out.println(Arrays.toString(promblem.plusOne(new int[]{9})));

    }
}

