package org.example;

import java.util.Stack;

public class LeetCode_1_100 {
    public static void main(String[] args) {
//        System.out.println(mySqrt(4));
//        System.out.println(mySqrt(8));
        System.out.println(new LeetCode_1_100().isValid("()[]{}"));


    }

    public boolean isValid(String s) { //20
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else if (stack.isEmpty()) return false;
            else if (s.charAt(i) == ')') {
                if (stack.pop() != '(') return false;
            } else if (s.charAt(i) == '}') {
                if (stack.pop() != '{') return false;
            } else if (s.charAt(i) == ']') {
                if (stack.pop() != '[') return false;
            }
        }
        return stack.isEmpty();

    }


    public static int mySqrt(int x) { //69
        if(x <= 1) {
            return x;
        }
        int start = 1, end = (x/2)+1, sqrt = 0;
        long mid = 0;

        while(start <= end) {
            mid = (start+end)/2;
            if(mid*mid == x) {
                return (int) mid;
            } else if(mid*mid < x) {
                start = (int) mid + 1;
                sqrt = (int) mid;
            } else {
                end = (int) mid - 1;
            }
        }

        return sqrt;

    }
    public int climbStairs(int n) { //70
        if (n==1) return 1;
        if (n==2) return 2;
        int[] a = new int[n];
        a[0] =  1;
        a[1] = 2;
        for (int i = 2; i < n; i++) {
            a[i] = a[i-1] + a[i-2];
        }
        return a[n-1];
    }
}
