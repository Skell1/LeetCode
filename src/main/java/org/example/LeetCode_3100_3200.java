package org.example;

public class LeetCode_3100_3200 {
    public static void main(String[] args) {

        System.out.println(new LeetCode_3100_3200());
    }

    public int scoreOfString(String s) { //3110
        int res = 0;
        for (int i = 0; i < s.length()-1; i++) {
            res += Math.abs(s.charAt(i) - s.charAt(i+1));
        }
        return res;
    }
}
