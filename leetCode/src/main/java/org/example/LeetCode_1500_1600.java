package org.example;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_1500_1600 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_1500_1600().threeConsecutiveOdds(new int[]{102,780,919,897,901}));
    }

    public boolean threeConsecutiveOdds(int[] arr) { //1550
        int count = 1;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] % 2 == 1) {
                if (arr[i + 1] % 2 == 1) {
                    count++;
                    if (count == 3) {
                        return true;
                    }
                } else {
                    count = 1;
                }
            } else count = 1;
        }
        return false;
    }

}
