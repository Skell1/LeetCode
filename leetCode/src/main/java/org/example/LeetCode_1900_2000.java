package org.example;

import java.util.Arrays;

public class LeetCode_1900_2000 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_1900_2000().countTriples(5));
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

    public int countTriples(int n) { //1925
        int sqrt = n*n;
        int result = 0;
        int temp;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                temp = i*i + j*j;
                if (temp <= sqrt) {
                    if (Math.sqrt(temp) % 1 == 0) {
                        result++;
                    }
                } else {
                    break;
                }
            }
        }
        return result;
    }

    public int canBeTypedWords(String text, String brokenLetters) { //1935
        if (brokenLetters.isEmpty()) return text.split(" ").length;
        String[] brokenLetter = brokenLetters.split("");
        int count = 0;
        for (String s : text.split(" ")) {
            for (String b : brokenLetter) {
                if (s.contains(b)) {
                    count--;
                    break;
                }
            }
            count++;
        }
        return count;
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

    public int minimumDifference(int[] nums, int k) { //1984
        Arrays.sort(nums);
        int a = 0, b = k-1;
        if (k> nums.length) {
            return 0;
        }
        int result = nums[b] - nums[a];
        while (b < nums.length) {
            if (nums[b] - nums[a] < result) {
                result = nums[b] - nums[a];
            }
            a++; b++;
        }
        return result;
    }
}
