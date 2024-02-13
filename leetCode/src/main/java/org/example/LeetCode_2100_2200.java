package org.example;

public class LeetCode_2100_2200 {
    public static void main(String[] args) {
        System.out.println(firstPalindrome(new String[]{"abc","car","ada","racecar","cool"}));
    }

    public static String firstPalindrome(String[] words) {//2108
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (words[i].contentEquals(stringBuilder.append(words[i]).reverse())) {
                return words[i];
            }
            stringBuilder.setLength(0);
        }
        return "";
    }

}
