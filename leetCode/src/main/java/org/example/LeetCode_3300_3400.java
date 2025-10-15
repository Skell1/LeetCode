package org.example;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_3300_3400 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_3300_3400().maxIncreasingSubarrays(List.of(-15,19)));

    }

    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) { //3349
        List<Integer> list = new ArrayList<>();
        list.add(0);
        int sum = 1;
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) > nums.get(i-1)) {
                sum++;
            } else {
                list.add(sum);
                sum = 1;
            }
            if (sum >= k) {
                if (sum >= 2*k || list.get(list.size()-1) >= k) {
                    return true;
                }
            }
        }
        return false;
    }

    public int maxIncreasingSubarrays(List<Integer> nums) { //3350
        List<Integer> list = new ArrayList<>();
        int max = 0;
        int result = 0;
        int sum = 1;
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) > nums.get(i-1)) {
                sum++;
            } else {
                list.add(sum);
                if (sum >= max) {
                    max = sum;
                }
                sum = 1;
            }
        }
        if (sum >= max) {
            max = sum;
        }
        list.add(sum);

        for (int i = 1; i < list.size(); i++) {
            sum = Math.min(list.get(i), list.get(i-1));
            if (sum > result) {
                result = sum;
            }
        }
        return Math.max(max / 2, result);
    }

    public int countSubarrays(int[] nums) { //3392
        int result = 0;
        for (int i = 0; i < nums.length-2; i++) {
            if (nums[i] + nums[i+2] == nums[i+1]/2d) {
                result++;
            }
        }
        return result;

    }

    public int minimumOperations(int[] nums) { //3396
        int[] arr = new int[1001];
        for (int i = nums.length-1; i >= 0; i--) {
            if (arr[nums[i]] == 0) {
                arr[nums[i]]++;
            } else {
                return (int) Math.ceil((i+1)/3d);
            }
        }
        return 0;
    }

}
