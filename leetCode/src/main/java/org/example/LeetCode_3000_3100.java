package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LeetCode_3000_3100 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_3000_3100().minimumPushes("xycdefghij"));
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

    public int minimumCost(int[] nums) { //3010
        int res = nums[0];
        nums[0] = Integer.MAX_VALUE;
        Arrays.sort(nums);
        return res + nums[0] + nums[1];
    }

    public long flowerGame(int n, int m) { //3021
        long countChetA = n % 2 == 0 ? n / 2 : (n-1) / 2;
        long countNeChetA = n - countChetA;

        long countChetB = m % 2 == 0 ? m / 2 : (m-1) / 2;
        long countNeChetB = m - countChetB;

        return countChetA*countNeChetB + countChetB*countNeChetA;

    }

    public int minimumPushes(String word) { //3014
        char[] chars = word.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int a = 1;
        int b = 1;
        int res = 0;
        for (Integer c : map.values().stream().sorted(Comparator.reverseOrder()).toList()) {
            if (a == 9) {
                a = 1;
                b++;
            }
            a++;
            res += b*c;
        }
        return res;
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

    public long maximumHappinessSum(int[] happiness, int k) { //3075
        long res = 0;
        Arrays.sort(happiness);
        int current = happiness.length;


        for (int i = 0; i < k; i++) {
            res += Math.max(happiness[--current] - i, 0);
        }
        return res;
    }

}
