package org.example;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_1500_1600 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_1500_1600().numSub("0110111"));
    }

    public int numSub(String s) { //1513
        long res = 0;
        int curr = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (curr == 0) {
                    continue;
                } else {
                    res += (long) (curr + 1) * curr / 2;
                    curr = 0;
                }
            } else {
                curr++;
            }
        }
        if (curr != 0) {
            res += (long) (curr + 1) * curr / 2;
        }
        return (int) (res % (1000000000+7));
    }

    public int numWaterBottles(int numBottles, int numExchange) { //1518
        int drinkCount = 0;
        int emptyCount = 0;

        while (true) {
            if (numBottles > 0) {
                emptyCount += numBottles;
                drinkCount += numBottles;
                numBottles = 0;
            } else if (emptyCount >= numExchange) {
                emptyCount -= numExchange;
                numBottles++;
            } else {
                break;
            }
        }
        return drinkCount;
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
