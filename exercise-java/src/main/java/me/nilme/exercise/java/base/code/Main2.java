package me.nilme.exercise.java.base.code;


class Main2 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

//        ListNode l2 = new ListNode(5);
//        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(7);

        ListNode l2 = new ListNode(0);

        int fun = Main2.fun(l1, 2);
        System.out.println(fun);

    }

    public static int fun(ListNode head, int d) {
        ListNode now = head;
        int length = 0;
        while (now != null) {
            length++;
            now = now.next;
        }
        length = length - d;
        for (int i = 0; i < length; i++) {
            head = head.next;
        }
        return head.val;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
