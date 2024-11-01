package org.example;

import java.util.Arrays;

public class LeetCode_1900_2000 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_1900_2000().validPath(3, new int[][]{{0,1},{1,2},{2,0}} , 0 , 2));
    }

    public static String largestOddNumber(String num) { //1903
        for (int i = num.length() - 1; i >= 0; i--) {
            if ((int) num.charAt(i) % 2 != 0){
                return num.substring(0, i + 1);
            }
        }
        return "";
    }

    public static int maxProductDifference(int[] nums) { //1913
        Arrays.sort(nums);
        System.gc();
        return nums[nums.length-1]*nums[nums.length-2]-nums[1]*nums[0];
    }

    public String makeFancyString(String s) { //1957
        StringBuilder sb = new StringBuilder(s);
        char c = sb.charAt(0);
        int count = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == c) {
                count++;
                if (count > 2) {
                    count--;
                    i--;
                    sb.deleteCharAt(i);
                }
            } else {
                c = sb.charAt(i);
                count = 1;
            }
        }
        return sb.toString();
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) { //1971
        int[] res = new int[n];
        res[source] = 1;
        boolean isChange = true;
        while (isChange) {
            if (res[destination] == 1) return true;
            isChange = false;
            for (int i = 0; i < edges.length; i++) {
                if (edges[i] != null) {
                    if (res[edges[i][0]] == 1) {
                        res[edges[i][1]] = 1;
                        edges[i] = null;
                        isChange = true;
                    } else if (res[edges[i][1]] == 1) {
                        res[edges[i][0]] = 1;
                        edges[i] = null;
                        isChange = true;
                    }
                }
            }
        }
        return res[destination] == 1;

    }

}
