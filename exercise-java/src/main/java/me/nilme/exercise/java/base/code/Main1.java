package me.nilme.exercise.java.base.code;

/**
 * Created by nilme on 2020/3/17.
 */
public class Main1 {

    public static void main(String[] args) {
        String result = Main1.fun("xddx");
        System.out.println(result);
    }

    public static String fun(String str){
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        int index[] = new int[26];
        for (int i = 0; i < length; i++) {
            char ch = str.charAt(i);
            if (index[ch-'a'] == 0){
                index[ch-'a'] =1;
                sb.append(ch);
            }
        }
        return sb.toString();
    }

}
