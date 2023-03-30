package me.nilme.exercise.java.leecode;


import java.util.PriorityQueue;

class Promblem23 {


    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue minHeap = new PriorityQueue();













        return null;
    }


    public static void main(String[] args) {
        Promblem23 promblem = new Promblem23();

        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(7);

        ListNode[] lists = {l1, l2};

        ListNode listNode = promblem.mergeKLists(lists);
    }
}