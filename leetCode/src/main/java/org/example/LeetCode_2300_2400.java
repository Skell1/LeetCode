package org.example;

import java.util.Arrays;

public class LeetCode_2300_2400 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LeetCode_2300_2400().successfulPairs(new int[]{5, 1, 3}, new int[]{1, 2, 3, 4, 5}, 7)));
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) { //2300
        Arrays.sort(potions);
        int[] res = new int[spells.length];
        int a,b;
        for (int i = 0; i < spells.length; i++) {
            a = 0;
            b = potions.length;
            while (a!=b) {
                if ((long) spells[i] * potions[(b+a)/2] >= success) {
                    b = (b+a)/2;
                } else {
                    a = (b+a)/2+1;
                }

            }
           res[i] = potions.length - a;
        }
        return res;
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
