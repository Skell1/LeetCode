package org.example;

public class LeetCode_2100_2200 {
    public static void main(String[] args) {
        System.out.println(rearrangeArray(new int[]{3,1,-2,-5,2,-4}));
    }

    public static int[] rearrangeArray(int[] a) {// 2149
        int n=a.length;
        int []ans=new int[n];
        int posIndex=0,negIndex=1;
        for (int j : a) {
            if (j > 0) {
                ans[posIndex] = j;
                posIndex += 2;
            } else {
                ans[negIndex] = j;
                negIndex += 2;
            }
        }
        return ans;
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
