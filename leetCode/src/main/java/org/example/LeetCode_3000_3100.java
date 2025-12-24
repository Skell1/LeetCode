package org.example;

import java.util.Arrays;

public class LeetCode_3000_3100 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_3000_3100().flowerGame(100000,100000));
    }

    public int areaOfMaxDiagonal(int[][] dimensions) { //3000
        double res = 0;
        int result = 0;
        for (int[] dimension : dimensions) {
            double def = Math.sqrt(dimension[0] * dimension[0] + dimension[1] * dimension[1]);
            if (def > res) {
                res = def;
                result = dimension[0]*dimension[1];
            }
            if (def == res) {
                result = Math.max(dimension[0] * dimension[1], result);
            }
        }
        return result;
    }

    public int maxFrequencyElements(int[] nums) { //3005
        int[] array = new int[101];

        for (int num : nums) {
            array[num] += 1;
        }
        int max = 0;
        for (int j : array) {
            if (j > max) max = j;
        }
        int count = 0;
        for (int j : array) {
            if (j == max) count++;
        }
        return max*count;
    }

    public long flowerGame(int n, int m) { //3021
        long countChetA = n % 2 == 0 ? n / 2 : (n-1) / 2;
        long countNeChetA = n - countChetA;

        long countChetB = m % 2 == 0 ? m / 2 : (m-1) / 2;
        long countNeChetB = m - countChetB;

        return countChetA*countNeChetB + countChetB*countNeChetA;

    }

    public String triangleType(int[] nums) { //3024
        if (nums[0] + nums[1] <= nums[2] ||
                nums[0] + nums[2] <= nums[1] ||
                nums[1] + nums[2] <= nums[0]) return "none";
        if (nums[1] == nums[2] && nums[1] == nums[0]) return "equilateral";
        if (nums[0] == nums[1] || nums[1] == nums[2] || nums[0] == nums[2]) return "isosceles";
        return "scalene";
    }

    public int minimumBoxes(int[] apple, int[] capacity) { //3074
        Arrays.sort(capacity);
        int current = capacity.length;
        int res = 0;
        long sum = 0;
        for (int appleIndex : apple) {
            sum += appleIndex;
        }
        while (sum > 0) {
            sum -= capacity[--current];
            res++;
        }
        return res;
    }

}
