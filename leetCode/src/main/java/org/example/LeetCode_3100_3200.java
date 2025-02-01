package org.example;

public class LeetCode_3100_3200 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_3100_3200().isArraySpecial(new int[]{4,3,1,6}));
    }

    public boolean isArraySpecial(int[] nums) { //3151
        for (int i = 0; i < nums.length - 1; i++) {
            if ((nums[i] + nums[i + 1]) % 2 == 0) {
                return false;
            }
        }
        return true;
    }

}
