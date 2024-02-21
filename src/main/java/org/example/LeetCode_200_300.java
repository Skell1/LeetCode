package org.example;

import java.util.Stack;

public class LeetCode_200_300 {
    public static void main(String[] args) {
        rangeBitwiseAnd(2,2);
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
