package org.example;

import java.util.Arrays;

public class LeetCode_2900_3000 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_2900_3000().shortestBeautifulSubstring("100011001", 3));
    }

    public String shortestBeautifulSubstring(String s, int k) { //2904
        int a = 0, b = 0, count = 0;
        long integer = Long.MAX_VALUE;
        long temp;
        String res = "";
        while (b < s.length()) {
            if (s.charAt(b) == '1') {
                count++;
                if (count == k) {
                    while (s.charAt(a) == '0') {
                        a++;
                    }
                    count--;
                    temp = Long.parseLong(s.substring(a, b+1));
                    if (temp < integer) {
                        integer = temp;
                        res = s.substring(a, b+1);
                    }
                    a++;
                }
            }
            b++;
        }
        return res;
    }

    public int missingInteger(int[] nums) { //2996
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                sum += nums[i];
            } else {
                break;
            }
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == sum) {
                sum++;
            } else if (nums[i] > sum) {
                break;
            }
        }
        return sum;
    }
}
