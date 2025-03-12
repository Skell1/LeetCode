package org.example;

public class LeetCode_2500_2600 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_2500_2600()
                .maximumCount(new int[]{-2,-1,-1,1,2,3}));
    }

    public int maximumCount(int[] nums) { //2529
        int negCount = binarySearch(nums, 0);
        int posCount = nums.length - binarySearch(nums, 1);
        return Math.max(negCount, posCount);
    }

    private int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1, result = nums.length;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                result = mid;
                right = mid - 1;
            }
        }

        return result;
    }

    public long coloredCells(int n) { //2579
        long a = (2L * n - 1) * (2L * n - 1);
        long b = (long) n * (n-1) * 2;
        return a-b;
    }



}
