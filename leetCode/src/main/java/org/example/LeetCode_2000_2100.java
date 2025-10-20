package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_2000_2100 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_2000_2100().findEvenNumbers(new int[]{2,1,3,0}));
    }

    public int finalValueAfterOperations(String[] operations) { //2011
        int x = 0;
        for(String op : operations) {
            if (op.contains("+")) {
                x++;
            } else x--;
        }
        return x;
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
