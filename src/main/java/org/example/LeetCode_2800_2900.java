package org.example;

import java.util.Objects;

public class LeetCode_2800_2900 {
    public static void main(String[] args) {
        ListNode head = new ListNode(2, new ListNode(8, new ListNode(9)));
        System.out.println(new LeetCode_2800_2900().doubleIt(head));
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode doubleIt(ListNode head) { //2816
        ListNode newHead = null;
        if (head.val >= 5) {
            newHead = new ListNode(1, head);
        }
        ListNode curr = head;
        while (curr != null) {
            curr.val = curr.val * 2 % 10 + (curr.next == null ? 0 : curr.next.val*2 / 10);
            curr = curr.next;
        }
        return Objects.isNull(newHead) ? head : newHead;

    }

}
