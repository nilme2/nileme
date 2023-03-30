package me.nilme.exercise.java.leecode;

/**
 * Created by nilme on 2020/1/9.
 */
public class Promblem13 {
    public int romanToInt(String s) {
        String key = "IVXLCDM";
        int[] value = {1, 5, 10, 50, 100, 500, 1000};
        int length = s.length();
        int sum = 0;

        for (int i = 0; i < length; i++) {
            int index = key.indexOf(s.charAt(i));
            int v = value[index];
            if (i +1 < length) {
                int index2 = key.indexOf(s.charAt(i + 1));
                if (index < index2) {
                    v = -v;
                }
            }
            sum += v;
        }
        return sum;
    }


    public static void main(String[] args) {

        Promblem13 promblem13 = new Promblem13();

        System.out.println(promblem13.romanToInt("III"));
        System.out.println(promblem13.romanToInt("IV"));
        System.out.println(promblem13.romanToInt("IX"));
        System.out.println(promblem13.romanToInt("LVIII"));
        System.out.println(promblem13.romanToInt("MCMXCIV"));

    }
}

