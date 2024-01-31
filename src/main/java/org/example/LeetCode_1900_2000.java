package org.example;

import java.util.Arrays;

public class LeetCode_1900_2000 {
    public static void main(String[] args) {
        System.out.println(maxProductDifference(new int[]{5,6,2,7,4}));
        System.out.println(largestOddNumber("35427"));
    }

    public static int maxProductDifference(int[] nums) { //1913
        Arrays.sort(nums);
        System.gc();
        return nums[nums.length-1]*nums[nums.length-2]-nums[1]*nums[0];
    }

    public static String largestOddNumber(String num) { //1903
        for (int i = num.length() - 1; i >= 0; i--) {
            if ((int) num.charAt(i) % 2 != 0){
                return num.substring(0, i + 1);
            }
        }
        return "";
    }
}
