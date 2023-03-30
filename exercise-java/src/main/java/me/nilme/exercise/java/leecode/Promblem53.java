package me.nilme.exercise.java.leecode;


class Promblem53 {


    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int last = nums[0];
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            last = Math.max(last + nums[i], nums[i]);
            max = Math.max(last, max);
        }
        return max;
    }


    public static void main(String[] args) {
        Promblem53 promblem = new Promblem53();

        int a[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println(promblem.maxSubArray(a));

    }
}