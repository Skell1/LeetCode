package org.example;

public class LeetCode_2500_2600 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_2500_2600()
                .coloredCells(2));
    }

    public long coloredCells(int n) { //2579
        long a = (2L * n - 1) * (2L * n - 1);
        long b = (long) n * (n-1) * 2;
        return a-b;
    }



}
