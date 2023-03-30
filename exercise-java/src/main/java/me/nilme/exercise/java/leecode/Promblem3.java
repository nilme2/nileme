package me.nilme.exercise.java.leecode;

/**
 * Created by nilme on 2020/1/9.
 */
public class Promblem3 {

    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        int begin = 0;
        int max = 0;

        int currentLength = 1;

        for (int i = 1; i < s.length(); i++) {
            char x = s.charAt(i);
            int index = isContent(s, begin, i, x);
            if (index >= 0) {
                int length = i - begin;
                currentLength = i - index;
                if (length > max) {
                    max = length;
                }
                begin = index + 1;
            }else{
                currentLength++;
            }
        }

        if (currentLength> max){
            max = currentLength;
        }

        return max;
    }

    public int isContent(String s, int begin, int end, char x) {
        for (int j = begin; j < end; j++) {
            char y = s.charAt(j);
            if (y == x) {
                return j;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        Promblem3 promblem3 = new Promblem3();

//        String s = "abba";
//        String s = "abcabcbb";
        String s = "dvdf";
        int index = promblem3.isContent(s, 0, 1, 'p');
        System.out.println(index);

        int res = promblem3.lengthOfLongestSubstring(s);

        System.out.println(res);


    }
}

