package org.example;

import java.util.Arrays;

public class LeetCode_2700_2800 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_2700_2800().sumOfSquares(new int[]{1,2,3,4}));
    }

    public static int buyChoco(int[] prices, int money) { //2706
        Arrays.sort(prices);
        return prices[0]+prices[1]>money ? money : money-(prices[0]+prices[1]);
    }

    public int sumOfSquares(int[] nums) {//2778
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums.length % (i+1) == 0) {
                res += nums[i] * nums[i];
            }
        }
        return res;
    }

}
