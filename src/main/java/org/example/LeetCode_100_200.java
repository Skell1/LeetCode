package org.example;


import java.util.*;

import org.example.util.TreeNode;

public class LeetCode_100_200 {
    public static void main(String[] args) {
        int[] a = new  int[] {1,2,3,4,5,6,7};
        int[] b = new  int[] {-1,-100,3,99};
        rotate(a,3);

        rotate(b,2);
        new LeetCode_100_200().rob(new int[]{1,2,3,1});
    }

    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

    public boolean hasCycle(ListNode head) { //141
        HashSet<ListNode> set = new HashSet<>();
        set.add(head);
        while (head.next!=null) {
            head = head.next;
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
            }
        }
        return false;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) { //100
        if (p == null && q == null) return true;
        if (p == null || q == null || p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }


    public int majorityElement(int[] nums) {//169
        if (nums.length == 1) return nums[0];
        int maxCount = 0;
        int maxIndex = 0;
        int def, dep;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            def = nums[i];
            if (map.containsKey(def)) {
                dep = map.get(def) + 1;
                map.put(def, dep);
                if (dep > maxCount) {
                    maxCount = dep;
                    maxIndex = def;
                }
            }
            else map.put(def, 1);
        }
        return maxIndex;
    }

    public int evalRPN(String[] tokens) { //150
        Stack<Integer> stack = new Stack<>();
        String temp;
        Integer num;
        for (int i = 0; i < tokens.length; i++) {
            temp = tokens[i];
            if (temp.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            }
            else if (temp.equals("-")) {
                num = stack.pop();
                stack.push(stack.pop() - num);
            }
            else if (temp.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            }
            else if (temp.equals("/")) {
                num = stack.pop();
                stack.push(stack.pop() / num);
            }
            else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.peek();
    }

    public int rob(int[] nums) { //198
        int n = nums.length;
        int pre = 0, cur = 0;
        for (int i = 0; i < n; i++) {
            int temp = Math.max(pre + nums[i], cur);
            pre = cur;
            cur = temp;
        }
        return cur;
    }

    public static void rotate(int[] nums, int k) { // 189
        final int size = nums.length;
        if (k > size) k = k % size;
        int[] a = new int[size-k];
        int[] b = new int[k];
        System.arraycopy(nums, 0, a, 0, size-k);
        System.arraycopy(nums, size-k, b, 0, k);
        System.arraycopy(b, 0, nums, 0,k);
        System.arraycopy(a, 0, nums, k, size-k);
   }
}
