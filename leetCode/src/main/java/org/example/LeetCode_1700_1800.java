package org.example;

public class LeetCode_1700_1800 {
    public static void main(String[] args) {
        System.out.println(totalMoney(10));
    }

    public static int totalMoney(int n) { //1716
        int k = 0;
        int week = 1;
        for (int i = 0; i < n;) {
            for (int j = week; j < 7 + week && i < n; j++, i++ ){
                k += j;
            }
            week++;
        }
        return k;
    }
}
