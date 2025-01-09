package org.example;

import org.example.util.ListNode;

public class LeetCode_2100_2200 {
    public static void main(String[] args) {
        ListNode head = new ListNode(0, new ListNode(3, new ListNode(1, new ListNode(0, new ListNode(4, new ListNode(5,new ListNode(2,new ListNode(0))))))));
        System.out.println(new LeetCode_2100_2200().mergeNodes(head));
    }



    public static String firstPalindrome(String[] words) {//2108
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (words[i].contentEquals(stringBuilder.append(words[i]).reverse())) {
                return words[i];
            }
            stringBuilder.setLength(0);
        }
        return "";
    }

    public static int[] rearrangeArray(int[] a) {// 2149
        int n=a.length;
        int []ans=new int[n];
        int posIndex=0,negIndex=1;
        for (int j : a) {
            if (j > 0) {
                ans[posIndex] = j;
                posIndex += 2;
            } else {
                ans[negIndex] = j;
                negIndex += 2;
            }
        }
        return ans;
    }

    public ListNode mergeNodes(ListNode head) { //2181
        ListNode result = new ListNode();
        ListNode res = result;
        int curr = 0;
        head = head.next;
        while (head.next != null) {
            if (head.val == 0) {
                res.val = curr;
                curr = 0;
                res.next = new ListNode();
                res = res.next;
            } else {
                curr+= head.val;
            }
            head = head.next;
        }
        res.val = curr;
        return result;
    }

}
