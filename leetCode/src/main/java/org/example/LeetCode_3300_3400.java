package org.example;

public class LeetCode_3300_3400 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_3300_3400().countSubarrays(new int[]{-1,-4,-1,4}));

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
