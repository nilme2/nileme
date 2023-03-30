package me.nilme.exercise.java.leecode;

/**
 * Created by nilme on 2020/1/9.
 */
public class Promblem14 {
    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        String a = strs[0];
        for (int j = 0; j < a.length(); j++) {
            char x = a.charAt(j);
            for (int i = 1; i < strs.length; i++) {
                String temp = strs[i];
                if (temp.length() <= j) {
                    return a.substring(0, j);
                } else {
                    char y = temp.charAt(j);
                    if (y != x) {
                        return a.substring(0, j);
                    }
                }
            }
        }
        return strs[0];
    }


    public static void main(String[] args) {

        Promblem14 promblem14 = new Promblem14();

//        System.out.println(promblem14.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
//        System.out.println(promblem14.longestCommonPrefix(new String[]{"dog","racecar","car"})+"--");
//        System.out.println(promblem14.longestCommonPrefix(new String[]{})+"--");
//        System.out.println(promblem14.longestCommonPrefix(new String[]{"abc"}));
//        System.out.println(promblem14.longestCommonPrefix(new String[]{"c", "c"}));
        System.out.println(promblem14.longestCommonPrefix(new String[]{"aa","a"}));

    }
}

