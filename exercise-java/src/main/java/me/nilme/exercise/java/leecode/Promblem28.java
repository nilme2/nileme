package me.nilme.exercise.java.leecode;

/**
 * Created by nilme on 2020/1/9.
 */
public class Promblem28 {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) return 0;
        if (haystack != null && needle.length() > haystack.length()) return -1;

        for (int i = 0; i < haystack.length(); i++) {
            int index = i;
            for (int j = 0; j < needle.length(); j++) {
                if (index >= haystack.length()) {
                    break;
                }
                if (haystack.charAt(index) == needle.charAt(j)) {
                    if (j == needle.length() - 1) {
                        return i;
                    }
                    index++;
                } else {
                    break;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Promblem28 promblem = new Promblem28();
        System.out.println(promblem.strStr("hello", "ll"));
        System.out.println(promblem.strStr("hello", "lll"));
        System.out.println(promblem.strStr("aaaaa", "bba"));
        System.out.println(promblem.strStr("aaaaa", "a"));
        System.out.println(promblem.strStr("aaaaa", ""));
        System.out.println(promblem.strStr("abc1cdttt1cbtttt", "1cb"));
        System.out.println(promblem.strStr("aaa", "aaaa"));
        System.out.println(promblem.strStr("mississippi", "issipi"));
    }
}

