package org.example;

import org.example.util.TreeNode;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public class LeetCode_2300_2400 {
    public static void main(String[] args) {

    }

    public long zeroFilledSubarray(int[] nums) { //2348
        long res = 0;
        long n = 0;

        for (int num : nums) {
            if (num == 0) {
                n++;
            } else {
                if (n != 0) {
                    res += (n + 1) * n / 2;
                    n = 0;
                }
            }
        }
        if (n != 0) {
            res+= (n+1)*n/2;
        }
        return res;
    }

    public int minimumRecolors(String blocks, int k) { //2379
        int min = k;
        int curr = 0;
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') curr++;
        }
        if (curr < min) min = curr;


        for (int i = k; i < blocks.length(); i++) {
            if (blocks.charAt(i) == 'W') curr++;
            if (blocks.charAt(i-k) == 'W') curr--;
            if (curr < min) min = curr;
        }
        return min;

    }



    }
