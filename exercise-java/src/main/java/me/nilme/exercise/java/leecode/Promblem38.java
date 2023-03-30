package me.nilme.exercise.java.leecode;

/**
 * Created by nilme on 2020/1/9.
 */
public class Promblem38 {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String str = "11";
        for (int j = 2; j < n; j++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for (int i = 0; i < str.length(); i++) {
                if (i + 1 < str.length() &&  str.charAt(i) == str.charAt(i + 1)) {
                    count++;
                } else {
                    sb.append(count).append(str.charAt(i));
                    count = 1;
                }
            }
            str = sb.toString();
        }

        return str;
    }

    public static void main(String[] args) {
        Promblem38 promblem = new Promblem38();
//        System.out.println(promblem.countAndSay(5));
        System.out.println(promblem.countAndSay(4));

    }
}

