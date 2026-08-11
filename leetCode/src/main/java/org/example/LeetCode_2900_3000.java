package org.example;

import java.util.Arrays;

public class LeetCode_2900_3000 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_2900_3000().missingInteger(new int[]{37,1,2,9,5,8,5,2,9,4}));
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
