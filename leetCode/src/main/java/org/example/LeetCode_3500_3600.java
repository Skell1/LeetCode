package org.example;

public class LeetCode_3500_3600 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_3500_3600().findClosest(2,7,4));

    }

    public int findClosest(int x, int y, int z) { //3516
        int diff = Math.abs(x - z) - Math.abs(y - z);
        if (diff > 0) return 2;
        else if (diff == 0) return 0;
        else return 1;
    }

}
