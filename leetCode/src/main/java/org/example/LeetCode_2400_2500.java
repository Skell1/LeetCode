package org.example;

import org.example.util.TreeNode;

import java.util.Map;
import java.util.Set;

public class LeetCode_2400_2500 {
    public static void main(String[] args) {

    }

    public int[] applyOperations(int[] nums) { //2460
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i+1]) {
                nums[i] *= 2;
                nums[i+1] = 0;
            }
        }
        int[] res = new int[nums.length];
        int k=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                res[k] = nums[i];
                k++;
            }
        }
        return res;
    }



}
