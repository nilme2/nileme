package me.nilme.exercise.java.base.code;

/**
 * Created by nilme on 2020/3/17.
 */
public class Main3 {

    public static void main(String[] args) {

        int[] nums = {2, 5, 7, 6};


        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            makeHeap(nums, i, nums.length);
        }

        for (int i = nums.length - 1; i > 0; i--) {
            int a = nums[0];
            nums[0] = nums[i];
            nums[i] = a;
            makeHeap(nums, 0, i);
        }

        for (int num : nums) {
            System.out.print(num +" ");
        }
    }

    private static void makeHeap(int[] list, int i, int length) {
        int temp = list[i];
        for (int j = 2 * i + 1; j < length; j = 2 * j + 1) {
            //构建大顶堆表示升序  ,<表示大顶堆 , >表示小顶堆
            if (j + 1 < length && list[j] > list[j + 1]) {
                j++;
            }
            //构建大顶堆表示升序  ,>表示大顶堆 , <表示小顶堆
            if (list[j] > temp) {
                list[i] = list[j];
                i = j;
            } else {
                break;
            }
        }
        list[i] = temp;
    }

}
