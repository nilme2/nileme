package me.nilme.exercise.java.concurrent.arithmetic.minheap;

import java.util.PriorityQueue;

/**
 * Created by nilme on 2020/4/22.
 */
public class PriorityQueueMinHeap {
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(); //小顶堆，默认容量为11

        int a[] = {1, 3, 5, 7, 2, 4, 6};
        for (int i : a) {
            if (minHeap.size() < 5) {
                minHeap.add(i);
                continue;
            }
            if (i > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(i);
            }
        }

        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.poll() + " ");
        }


    }
}
