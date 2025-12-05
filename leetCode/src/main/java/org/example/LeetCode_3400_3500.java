package org.example;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_3400_3500 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_3400_3500().countPartitions(new int[]{10,10,3,7,6}));

    }

    public int countPartitions(int[] nums) { //3432
        int result = 0;
        int left = 0;
        int right = 0;
        for (int num : nums) {
            right += num;
        }

        for (int i = 0; i < nums.length-1; i++) {
            left += nums[i];
            right -= nums[i];
            if ((left - right) % 2 == 0) {
                result++;
            }
        }
        return result;

    }

    public boolean hasSameDigits(String s) { //3461
        StringBuilder sb = new StringBuilder();
        while (s.length() >2) {
            for (int i = 0; i < s.length()-1; i++) {
                int a = (s.charAt(i) + s.charAt(i+1) - '0' - '0') % 10;
                sb.append(a);
            }
            s = sb.toString();
            sb = new StringBuilder();
        }
        return s.charAt(0) == s.charAt(1);
    }

}
