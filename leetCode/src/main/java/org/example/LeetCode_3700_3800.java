package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCode_3700_3800 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_3700_3800().minMoves(new int[]{2,1,3}));

    }

    public long maxAlternatingSum(int[] nums) { //3727
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);

        long res = 0;
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            res += nums[j];
            j--;
            if (i <= j) {
                res -= nums[i];
                i++;
            }
        }
        return res;
    }

    public List<Integer> findMissingElements(int[] nums) { //3731
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            while (nums[i] + 1 != nums[i + 1]) {
                res.add(nums[i]+1);
                nums[i]++;
            }

        }
        return res;
    }

    public int minMoves(int[] nums) { //3736
        int sum = 0, max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            sum += max - nums[i];
        }
        return sum;
    }

    public int totalWaviness(int num1, int num2) { //3751
        int count = 0;
        for (int i = num1; i <= num2; i++) {
            if (i < 100) {
                continue;
            }
            count += checkInt(i);
        }
        return count;
    }

    private int checkInt(int num) {
        int res = 0;
        int first = num % 10;
        num = num / 10;
        int second = num % 10;
        num = num / 10;
        int third = num % 10;
        if ((second > first && second > third) || (second < first && second < third)) {
            res++;
        }
        while (num / 10 > 0) {
            num = num / 10;
            first = second;
            second = third;
            third = num % 10;
            if ((second > first && second > third) || (second < first && second < third)) {
                res++;
            }
        }
        return res;

    }
}
