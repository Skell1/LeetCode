package org.example;

import java.util.Arrays;

public class LeetCode_2700_2800 {
    public static void main(String[] args) {

    }

    public static int buyChoco(int[] prices, int money) { //2706
        Arrays.sort(prices);
        return prices[0]+prices[1]>money ? money : money-(prices[0]+prices[1]);
    }
}
