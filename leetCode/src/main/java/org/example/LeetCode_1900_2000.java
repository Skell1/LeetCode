package org.example;

public class LeetCode_1900_2000 {
    public static void main(String[] args) {
        System.out.println(largestOddNumber("35427"));
    }

    public static String largestOddNumber(String num) { //1903
        for (int i = num.length() - 1; i >= 0; i--) {
            if ((int) num.charAt(i) % 2 != 0){
                return num.substring(0, i + 1);
            }
        }
        return "";
    }
}
