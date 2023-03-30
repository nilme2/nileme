package me.nilme.exercise.java.concurrent.arithmetic.minheap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by nilme on 2020/3/4.
 */
public class Test {

    public static void main(String[] args) {

        int a[] = {1,3,5,7,2,4,6};

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(5, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for (int i : a) {
            if(minHeap.size()<5){
                minHeap.add(i);
                continue;
            }
            if (i<minHeap.peek()){
                minHeap.poll();
                minHeap.add(i);
            }
        }

        while (!minHeap.isEmpty()){
            System.out.println(minHeap.poll()+" ");
        }

    }
}
