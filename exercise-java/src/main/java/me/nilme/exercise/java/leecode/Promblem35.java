package me.nilme.exercise.java.leecode;

/**
 * Created by nilme on 2020/1/9.
 */
public class Promblem35 {
    public int searchInsert(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            if (target <= nums[i]) {
                return i;
            } else if (1 + i < nums.length && target <= nums[1 + i]) {
                return i + 1;
            }
        }

        return nums.length;
    }

    public static void main(String[] args) {
        Promblem35 promblem = new Promblem35();
        System.out.println(promblem.searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(promblem.searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(promblem.searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println(promblem.searchInsert(new int[]{1, 3, 5, 6}, 0));
        System.out.println(promblem.searchInsert(new int[]{1}, 0));

    }
}

