package org.example;

import java.util.Arrays;

public class LeetCode_2900_3000 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_2900_3000().shortestBeautifulSubstring("001110101101101111", 10));
    }

    public String shortestBeautifulSubstring(String s, int k) { //2904
        int a = 0, b = 0, count = 0;
        String temp;
        String res = "";
        while (b < s.length()) {
            if (s.charAt(b) == '1') {
                count++;
                if (count == k) {
                    while (s.charAt(a) == '0') {
                        a++;
                    }
                    count--;
                    temp = s.substring(a, b+1);
                    if (res.isEmpty() || temp.length() < res.length()) {
                        res = temp;
                    } else {
                        if (res.length() == temp.length()) {
                            for (int i = 0; i < temp.length(); i++) {
                                if (temp.charAt(i) == '1' && res.charAt(i) == '0') {
                                    break;
                                }
                                if (temp.charAt(i) == '0' && res.charAt(i) == '1') {
                                    res = temp;
                                    break;
                                }
                            }
                        }
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
