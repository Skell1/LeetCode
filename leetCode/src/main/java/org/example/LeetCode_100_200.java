package org.example;


import java.util.Stack;

public class LeetCode_100_200 {
    public static void main(String[] args) {
        int[] a = new  int[] {1,2,3,4,5,6,7};
        int[] b = new  int[] {-1,-100,3,99};
        rotate(a,3);

        rotate(b,2);
        new LeetCode_100_200().rob(new int[]{1,2,3,1});
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
