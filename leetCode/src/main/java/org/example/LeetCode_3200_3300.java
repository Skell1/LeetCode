package org.example;

import org.example.util.ListNode;

import java.util.*;

public class LeetCode_3200_3300 {
    public static void main(String[] args) {

//        ListNode body2 = new ListNode(9, null);
//        ListNode body1 = new ListNode(10, body2);
//        ListNode head = new ListNode(2, body1);

        ListNode body4 = new ListNode(1, null);
        ListNode body3 = new ListNode(8, body4);
        ListNode body2 = new ListNode(1, body3);
        ListNode body1 = new ListNode(7, body2);
        ListNode head = new ListNode(3, body1);

         System.out.println(new LeetCode_3200_3300().modifiedList(new int[]{1,7,6,2,4}, head));
    }

    public int maximumLength(int[] nums) { //3201
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        int cc = 0;
        int dd = 1;

        int temp;
        for (int i = 0; i < nums.length; i++) {
            temp = nums[i] % 2;
            if (temp == 0) {
                a++;
            } else {
                b++;
            }
            if (temp == cc) {
                c++;
                if (cc == 0) {
                    cc = 1;
                } else cc = 0;
            }
            if (temp == dd) {
                d++;
                if (dd == 0) {
                    dd = 1;
                } else dd = 0;
            }
        }
        return Math.max(Math.max(a, b), Math.max(c, d));
    }

    public ListNode modifiedList(int[] nums, ListNode head) { //3217
        ListNode result = head;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        boolean flag = true;
        while (flag) {
            flag = false;
            if (set.contains(result.val)) {
                result= result.next;
                flag = true;
            }
        }

        ListNode before = result;
        ListNode current = result.next;
        while (before!= null && current != null) {
            flag = false;
            if (set.contains(current.val)) {
                    before.next=current.next;
                    current = current.next;
                    flag = true;
            }
            if (flag) {
                continue;
            }
            before = before.next;
            if (before != null) {
                current = before.next;
            }
        }
        return result;
    }

    public int[] getSneakyNumbers(int[] nums) { //3289
        int[] temp = new int[100];
        int[] result = new int[2];
        int j = 0;
        for (int num : nums) {
            temp[num]++;
            if (temp[num] == 2) {
                result[j] = num;
                j++;
            }
        }
        return result;
    }

}
