package me.nilme.exercise.java.leecode;

/**
 * Created by nilme on 2020/1/9.
 */
public class Promblem9 {
    public boolean isPalindrome(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while(x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        return x == revertedNumber || x == revertedNumber/10;
    }


    public static void main(String[] args) {

        Promblem9 promblem9 = new Promblem9();

        System.out.println(promblem9.isPalindrome(101));
        System.out.println(promblem9.isPalindrome(121));
        System.out.println(promblem9.isPalindrome(313));
        System.out.println(promblem9.isPalindrome(1000021));

    }
}

