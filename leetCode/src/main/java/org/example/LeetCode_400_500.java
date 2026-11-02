package org.example;

import java.util.Arrays;

public class LeetCode_400_500 {
    public static void main(String[] args) {

    }

    public int minMoves2(int[] nums) { //462
        Arrays.sort(nums);
        int med = nums[nums.length / 2];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += Math.abs(nums[i] - med);
        }
        return res;
    }
}
