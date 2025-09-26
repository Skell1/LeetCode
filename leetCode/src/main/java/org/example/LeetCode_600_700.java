package org.example;

import java.util.Arrays;

public class LeetCode_600_700 {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(imageSmoother(new int[][]{{100, 200, 100}, {200, 50, 200}, {100, 200, 100}})));
    }

    public int triangleNumber(int[] nums) { //611
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i]+nums[j]>nums[k]) {
                        sum++;
                    } else {
                        break;
                    }
                }
            }
        }
        return sum;
    }

    public static int[][] imageSmoother(int[][] img) { //661
        int x = img.length;
        int y = img[0].length;
        int[][] result = new int[x][y];
        int a;
        int count;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                a = img[i][j];
                count = 1;
                if (i>0) {
                    a+= img[i-1][j];
                    count++;
                    if (j>0) {
                        a += img[i - 1][j - 1];
                        count++;
                    }
                    if (j<y-1) {
                        a += img[i - 1][j + 1];
                        count++;
                    }
                }
                if (i<x-1){
                    a+=img[i+1][j];
                    count++;
                    if (j>0) {
                        a += img[i + 1][j - 1];
                        count++;
                    }

                    if (j<y-1) {
                        a += img[i + 1][j + 1];
                        count++;
                    }

                }

                if (j>0) {
                    a+= img[i][j-1];
                    count++;
                }
                if (j<y-1){
                    a+=img[i][j+1];
                    count++;
                }
                result[i][j]= a/count;

            }

        }
        System.gc();
        return result;
    }

}
