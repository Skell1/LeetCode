package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_3800_3899 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_3800_3899().countCommas(4848));

    }

    public int countCommas(int n) { //3870
        return Math.max(0, n-999);
    }
}
