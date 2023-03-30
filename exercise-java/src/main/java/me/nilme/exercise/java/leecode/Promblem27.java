package me.nilme.exercise.java.leecode;

/**
 * Created by nilme on 2020/1/9.
 */
public class Promblem27 {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Promblem27 promblem = new Promblem27();
        int duplicates = promblem.removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2);
        System.out.println(duplicates);

        int duplicates2 = promblem.removeElement(new int[]{3,2,2,3}, 3);
        System.out.println(duplicates2);
    }
}

