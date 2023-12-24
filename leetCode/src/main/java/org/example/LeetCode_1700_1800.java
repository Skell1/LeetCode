package org.example;

public class LeetCode_1700_1800 {
    public static void main(String[] args) {

        System.out.println(minOperations("1111"));
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

    public static int minOperations(String s) { //1758
        int k0 = 0, k1 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0){
                if (s.charAt(i) == '1')
                    k0++;
                else k1++;
            }
            else {
                if (s.charAt(i) == '1')
                    k1++;
                else k0++;
            }
        }
        return Math.min(k0, k1);
    }
}
