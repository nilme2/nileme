package me.nilme.exercise.java.leecode;


class Promblem10 {


    public boolean isMatch(String s, String p) {

        int[][] dp = new int[s.length()][p.length()];

        return false;

    }

    public static void main(String[] args) {
        Promblem10 promblem = new Promblem10();

        String s = "mississippi";
        String p = "mis*is*p*.";

        System.out.println(promblem.isMatch(s, p));

    }
}