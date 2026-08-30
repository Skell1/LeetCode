package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_2000_2100 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_2000_2100().minimumDeletions(new int[]{48,-49,-67,18,-59,-56,47,-26,-24,-73,-96,27,-2,-45}));
    }

    public int finalValueAfterOperations(String[] operations) { //2011
        int res = 0;
        for(String op : operations) {
            if (op.contains("+")) {
                res++;
            } else res--;
        }
        return res;
    }

    public int maxDistance(int[] colors) { //2078
        int a = 0, b = 0;
        for (int i = 0; i < colors.length; i++) {
            if (a == 0 && colors[colors.length - 1 - i] != colors[0] ) {
                a = colors.length - 1 - i;
            }
            if (b == 0 && colors[colors.length - 1] != colors[i] ) {
                b = colors.length - 1 - i;
            }
            if (a!=0 && b!=0) {
                break;
            }
        }
        return Math.max(a,b);
    }

    public int minimumDeletions(int[] nums) { //2091
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minIndex = 0;
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
                minIndex = i;
            }
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        min = Math.min(maxIndex, minIndex);
        max = Math.max(maxIndex, minIndex);
        return Math.min(Math.min(min + nums.length-max+1, max+1), nums.length - min);
    }

    public int[] findEvenNumbers(int[] digits) { //2094
        List<Integer> evenNumbers = new ArrayList<>();
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == 0) continue;
            for (int j = 0; j < digits.length; j++) {
                if (j == i) continue;
                for (int k = 0; k < digits.length; k++) {
                    if (k == i || k == j) continue;
                    if (digits[k] % 2 == 0) {
                        evenNumbers.add(digits[i]*100 + digits[j]*10 + digits[k]);
                    }
                }
            }
        }
        return evenNumbers.stream().distinct().sorted().mapToInt(i -> i).toArray();
    }
}
