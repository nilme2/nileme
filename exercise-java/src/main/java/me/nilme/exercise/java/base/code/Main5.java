package me.nilme.exercise.java.base.code;

import java.util.Stack;

/**
 * Created by nilme on 2020/3/17.
 */
public class Main5 {

    public static void print(int[] arr) {
        for (int n = 0; n < arr.length; n++) {
            System.out.print(arr[n] + " ");
        }
        System.out.println();
    }

    public static void fun(int[] a) {

        int low = 0;
        int high = a.length - 1;

        Stack<Integer> stack = new Stack<Integer>();
        if (low < high) {
            stack.add(low);
            stack.add(high);
            while (!stack.isEmpty()) {
                int hi = stack.pop();
                int lo = stack.pop();
                int key = partition(a, lo, hi);
                if (lo < key - 1) {
                    stack.push(lo);
                    stack.push(key - 1);
                }
                if (hi > key) {
                    stack.push(key + 1);
                    stack.push(hi);//这样，最后入栈的就是key右边的部分，则下一次循环先处理key右边的部分
                }
            }
        }
    }

    public static int partition(int[] a, int low, int high) {
        int key = a[low];
        while (low < high) {
            while (a[high] >= key && low < high) {//大于等于key的数组元素不需要移动
                high--;
            }
            a[low] = a[high];
            while (a[low] <= key && low < high) {//小于于等于key的数组元素不需要移动
                low++;
            }
            a[high] = a[low];
        }
        a[low] = key;
        print(a);
        return low;
    }

    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 76, 13, 27, 49, 55, 4};
        fun(arr);
    }

}
