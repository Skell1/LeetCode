package org.example;

public class LeetCode_1_100 {
    public static void main(String[] args) {
//        System.out.println(mySqrt(4));
//        System.out.println(mySqrt(8));
        System.out.println(mySqrt(2147395599));


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
