package me.nilme.exercise.java.leecode;


class Promblem191 {


    public int hammingWeight(long n) {
        System.out.println(n);
        int count = 0;
        while(n!=0){
            n = n &(n-1);
            count ++;
        }
        return count;
    }

    public static void main(String[] args) {
        Promblem191 promblem = new Promblem191();

        System.out.println(promblem.hammingWeight(00000000000000000000000000001011));
        System.out.println(promblem.hammingWeight(00000000000000000000000010000000));
//        System.out.println(promblem.hammingWeight(11111111111111111111111111111101));

        System.out.println(5<<4);

    }
}