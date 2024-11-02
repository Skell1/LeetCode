package org.example;

public class LeetCode_2400_2500 {
    public static void main(String[] args) {
        ListNode head = new ListNode(5, new ListNode(2, new ListNode(12, new ListNode(3, new ListNode(8)))));

        System.out.println(new LeetCode_2400_2500().isCircularSentence("leetcode exercises sound delightful"));
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public int pivotInteger(int n) {  //2485
        int c = 1;
        while (c < n) {
            if (summ(1,c) == summ(c,n)) return c;
            if (summ(1,c) > summ(c,n)) return -1;
            c++;
        }
        return -1;
    }

    public int summ (int a, int b) {
        return (a+b)*(b-a+1)/2;
    }

    public int appendCharacters(String s, String t) { //2486
        //int max = 0;
        int curr = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(curr)) {
                curr+=1;
                //if (curr > max) max = curr;
                if (curr == t.length()) return  0;
            }
        }
        return t.length()-curr;
    }

    // 5,2,12,3,8
    public ListNode removeNodes(ListNode head) { //2487
        int a = head.val;
        ListNode before = head;
        ListNode curr = head.next;
        ListNode next = head.next;
        while (curr != null) {
            if (curr.val > a) {
                a = curr.val;
                head = curr;
                before = curr;
                curr = before.next;
                System.out.println(head.val);

            }
            else if (curr.val > before.val) {
                before = head;
                curr = head.next;
                // a = before.val;
                // head = before;
                // System.out.println(head.val);

            }
            else {
                if (curr.next == null) break;
                next = curr.next;
                while (next != null) {
                    if (next.val>a) {
                        before = next;
                        a = before.val;
                        curr = before.next;
                        next = null;
                        head = before;
                        System.out.println(head.val);
                    } else if (next.val > curr.val) {
                        before.next = next;
                        curr = before.next;
                        next = null;
                    }
                    else {
                        before = curr;
                        curr = next;
                        next = curr.next;
                    }
                }
            }

        }
        return head;
    }

    public boolean isCircularSentence(String sentence) { //2490
        String[] words = sentence.toLowerCase().split(" ");
        for (int i = 0; i < words.length-1; i++) {
            if (!(words[i].charAt(words[i].length()-1) == words[i+1].charAt(0))) return false;
        }
        if (words[words.length-1].charAt(words[words.length-1].length()-1) == words[0].charAt(0)) return true;
        return false;

    }


}
