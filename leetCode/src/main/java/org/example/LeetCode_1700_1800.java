package org.example;

import java.util.HashSet;
import java.util.Set;

public class LeetCode_1700_1800 {
    public static void main(String[] args) {

        System.out.println(new LeetCode_1700_1800().checkPowersOfThree(21));
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

    public boolean check(int[] nums) { //1752
        boolean newStrart = false;

        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] > nums[i+1]) {
                if (newStrart) return false;
                newStrart = true;
            }
        }
        if (newStrart) {
            return nums[nums.length-1] <= nums[0];
        }
        return true;

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

    public boolean checkPowersOfThree(int n) { //1780
        Set<Integer> set = new HashSet<>();
        while (n >= 3) {
            int s = 1;
            for (int i = 0; i < 16; i++) {
                s = s*3;
                if (s==n) {
                    if (set.contains(s)) return false;
                    n = n-s;
                    set.add(s);
                    break;
                }
                if (s>=n) {
                    s = s/3;
                    if (set.contains(s)) return false;
                    n = n-s;
                    set.add(s);
                    break;
                }
            }
        }
        return n == 2 ? false : true;
    }
}
