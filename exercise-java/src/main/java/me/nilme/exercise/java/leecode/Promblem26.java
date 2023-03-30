package me.nilme.exercise.java.leecode;

/**
 * Created by nilme on 2020/1/9.
 */
public class Promblem26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[index] != nums[i]) {
                index++;
                nums[index] = nums[i];
            }
        }
        return index+1;
    }

    public static void main(String[] args) {
        Promblem26 promblem = new Promblem26();
        int duplicates = promblem.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
        System.out.println(duplicates);
    }
}

