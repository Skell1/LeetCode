package org.example;

import java.util.Arrays;

public class LeetCode_2900_3000 {
    public static void main(String[] args) {
        System.out.println(divideArray(new int[]{1,3,4,8,7,9,3,5,1} , 2));
    }

    public static int[][] divideArray(int[] nums, int k) { //2966
        nums = Arrays.stream(nums).sorted().toArray();
        int[][] result = new int[nums.length/3][3];
        int i,j;
        for ( i = 0, j =0; i < nums.length; i+=3, j++) {
            if (nums[i+2] - nums[i] <=k) {
                result[j][0] = nums[i];
                result[j][1] = nums[i+1];
                result[j][2] = nums[i+2];
            }
            else return new int[0][0];
        }
        for (int l = 0; l < nums.length % 3; l++) {
            result[j][i] = nums[nums.length-3+l];
        }
        return result;
    }
}
