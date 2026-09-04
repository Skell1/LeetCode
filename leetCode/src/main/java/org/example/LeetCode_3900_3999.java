package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_3900_3999 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_3900_3999().firstStableIndex(new int[]{6,1,4}, 5));

    }

    public int firstStableIndex(int[] nums, int k) { //3903
        int res = Integer.MAX_VALUE;
        int find = -1;

        int pre = Integer.MIN_VALUE;
        int post;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > pre) {
                pre = nums[i];
            }
            post = findMin(nums, i);
            if (pre - post <= k) {
                if (res > (pre - post)) {
                    return i;
                }
            }
        }
        return find;

    }

    private int findMin(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        for (int i = k; i < nums.length; i++) {
            if (min > nums[i]) {
                min = nums[i];
            }
        }
        return min;
    }
}
