package me.nilme.exercise.java.base.code;

/**
 * Created by nilme on 2020/3/17.
 */
public class Main4 {

    public static void main(String[] args) {
        char data[] = {'a','b','c'};
        char[] chars = Main4.reverseString(data);
        System.out.println(chars);
    }

    public static char[] reverseString(char[] data) {
        int start = 0;
        int end = data.length-1;
        while (start < end) {
            char tmp = data[start];
            data[start] = data[end];
            data[end] = tmp;
            start++;
            end--;
        }
        return data;
    }
}
