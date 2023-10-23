package org.example;

public class LeetCode_300_400 {
    public static void main(String[] args) {
        System.out.println(isPowerOfFour(-16));
    }

    public static boolean isPowerOfFour(int n) {//342
        if (n< 0 ) return false;
       while (n >= 4 || n <= -4) {
            if (n % 4 != 0) return false;
            n /= 4;
        }
        if (n == 1) {
            return true;
        }
        else return false;
    }
}
