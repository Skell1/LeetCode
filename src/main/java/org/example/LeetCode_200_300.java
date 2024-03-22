package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LeetCode_200_300 {
    public static void main(String[] args) {
        new LeetCode_200_300().isPalindrome((null));
    }

    public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public boolean isPalindrome(ListNode head) { //234
        if (head == null) return false;
        List<Integer> list = new ArrayList<>();
        while (head!=null) {
            list.add(head.val);
            head = head.next;
        }
        for (int i = 0; i < list.size()/2; i++) {
            System.out.println(list.get(i) + "  " + list.get(list.size()-i-1) );
            if (list.get(i) != list.get(list.size()-i-1)) return false;
        }
        return true;
    }
    public ListNode reverseList(ListNode head) { //206
        if (head == null) return null;
        List<ListNode> list = new ArrayList<>();
        while (head!=null) {
            list.add(head);
            head = head.next;
        }

        for (int i = list.size()-1; i >=1 ; i--) {
            list.get(i).next = list.get(i-1);
        }
        list.get(0).next = null;
        return list.get(list.size()-1);
    }

    public int[] productExceptSelf(int[] nums) { //238
        int zeros = 0;
        int temp = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                temp *= nums[i];
            }
            else zeros++;
        }

        if (zeros > 1) {
            Arrays.fill(nums, 0);
            return nums;
        }

        for (int i = 0; i < nums.length; i++) {
            if (zeros == 1) {
                if (nums[i] != 0)
                    nums[i] = 0;
                else nums[i] = temp;
            }
            else nums[i] = temp/nums[i];
        }
        return nums;
    }

    public static int missingNumber1(int[] nums) {//268
        int ans = nums.length;

        for (int i = 0; i < nums.length; ++i) {
            int a = i ^ nums[i];
            ans ^= i ^ nums[i];
        }

        return ans;
    }
    public int missingNumber(int[] nums) { //268
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i]+1!=nums[i+1]){
                return nums[i]+1;
            }
        }
        if (nums[0]== 0)
        return nums[nums.length-1]+1;
        return 0;
    }

    public static int rangeBitwiseAnd(int left, int right) { //201
        String l = Integer.toBinaryString(left);
        String r = Integer.toBinaryString(right);
        if (l.length() != r.length()) return 0;
        StringBuilder builder = new StringBuilder();
        Boolean key = true;
        for (int i = 0; i < l.length(); i++) {
            if (key) {
                if (l.charAt(i) == r.charAt(i))
                    builder.append(l.charAt(i));
                else {
                    key = false;
                    builder.append(0);
                }
            }
            else builder.append(0);
        }
        int result = Integer.parseInt(builder.toString(), 2);
        return result;
    }

    public static boolean isPowerOfTwo(int n) { //231
        if (n<=0) return false;
        while (n > 2) {
            if (n % 2 != 0)
                return false;
            n /= 2;
        }
        return true;

    }

    public static class MyQueue {  // 232

        private int front;
        private Stack<Integer> s1 = new Stack<>();
        private Stack<Integer> s2 = new Stack<>();


        public void push(int x) {
            if (s1.isEmpty()){
                front = x;
            }
            s1.push(x);
        }

        public int pop() {
            if(s2.isEmpty()){
                while(!s1.isEmpty()){
                    s2.push(s1.pop());
                }
            }
            return s2.pop();
        }

        public int peek() {
            if (!s2.isEmpty()) {
                return s2.peek();
            }

            return front;
        }

        public boolean empty() {
            return (s1.isEmpty() && s2.isEmpty());
        }
    }
}
