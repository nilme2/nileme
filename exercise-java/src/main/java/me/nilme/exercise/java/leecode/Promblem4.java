package me.nilme.exercise.java.leecode;

/**
 * Created by nilme on 2020/1/9.
 */
public class Promblem4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int x = 0;
        int y = 0;
        int xi = 0;
        int yi = nums2.length;
        int al = nums1.length + nums2.length;
        int count = 1;
        while ((x + y) < al) {
        }


        return 1;
    }

    public static void main(String[] args) {
        Promblem4 promblem = new Promblem4();
        System.out.println(promblem.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));

    }
}

