package me.nilme.exercise.java.leecode;

/**
 * Created by nilme on 2020/1/9.
 */
public class Promblem2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int up = 0;
        ListNode res = null;
        ListNode now = null;

        while (l1 != null || l2 != null) {
            int a = 0;
            int b = 0;
            if (l1 != null) {
                a = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                b = l2.val;
                l2 = l2.next;
            }

            int sum = a + b + up;
            if (sum >= 10) {
                up = sum / 10;
                sum = sum % 10;
            } else {
                up = 0;
            }

            if (res == null) {
                res = new ListNode(sum);
                now = res;
            } else {
                now = now.next = new ListNode(sum);
            }
        }

        if (up > 0) {
            now.next = new ListNode(up);
        }

        return res;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

//        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(7);

        ListNode l2 = new ListNode(0);


        Promblem2 promblem2 = new Promblem2();
        ListNode listNode = promblem2.addTwoNumbers(l1, l2);

        while (listNode != null) {
            System.out.print(listNode.val + "->");
            listNode = listNode.next;
        }

    }
}

