package me.nilme.exercise.java.leecode;

/**
 * Created by nilme on 2020/1/9.
 */
public class Promblem21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }


    public static void main(String[] args) {

        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(7);

        Promblem21 promblem = new Promblem21();
        ListNode listNode = promblem.mergeTwoLists(l1, l2);

        System.out.println("");
    }
}

