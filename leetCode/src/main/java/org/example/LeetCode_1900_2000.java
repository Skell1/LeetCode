package org.example;

import java.util.Arrays;

public class LeetCode_1900_2000 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_1900_2000().removeOccurrences("aabababa", "aba"));
    }

    public static String largestOddNumber(String num) { //1903
        for (int i = num.length() - 1; i >= 0; i--) {
            if ((int) num.charAt(i) % 2 != 0){
                return num.substring(0, i + 1);
            }
        }
        return "";
    }

    public String removeOccurrences(String s, String part) { //1910

        while (s.indexOf(part) != -1) {
            s = s.replaceFirst(part, "");
        }
        return s;
    }

    public static int maxProductDifference(int[] nums) { //1913
        Arrays.sort(nums);
        System.gc();
        return nums[nums.length-1]*nums[nums.length-2]-nums[1]*nums[0];
    }

    public String makeFancyString(String s) { //1957
        StringBuilder sb = new StringBuilder(s);
        for (int i = 2; i < sb.length(); i++) {
            if (sb.charAt(i) == sb.charAt(i-1) && sb.charAt(i) == sb.charAt(i-2)) {
                sb.deleteCharAt(i);
                i--;
            }
        }
        return sb.toString();
    }
}
