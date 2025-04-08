package org.example;

public class LeetCode_3300_3400 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_3300_3400().minimumOperations(new int[]{1,2,3,4,2,3,3,5,7}));
        System.out.println(new LeetCode_3300_3400().minimumOperations(new int[]{4,5,6,4,4}));
        System.out.println(new LeetCode_3300_3400().minimumOperations(new int[]{6,7,8,9}));

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
