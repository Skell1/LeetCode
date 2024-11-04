package org.example;

import java.util.*;

public class LeetCode_500_600 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_500_600().checkSubarraySum(new int[]{0,1,0,3,0,4,0,4,0}
                , 5));
    }

    public String[] findRelativeRanks(int[] score) { //506
        int[] res = Arrays.copyOf(score, score.length);
        score = Arrays.stream(score).boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
        String[] result = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            for (int j = 0; j < score.length; j++) {
                if (res[i]==score[j]) {
                    if (j>2) {
                        result[i] = ""+(j+1);
                    } else if (j==0) {
                        result[i] = "Gold Medal";
                    } else if (j==1) {
                        result[i] = "Silver Medal";
                    } else {
                        result[i] = "Bronze Medal";
                    }
                }
            }
        }
        return result;
    }

    public boolean checkSubarraySum(int[] nums, int k) { //523
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sum %= k;
            if (sum == 0 && i > 0) {
                return true;
            }
            if (map.containsKey(sum) && i - map.get(sum) > 1) {
                return true;
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }

        }
        return false;

    }

    public int findMaxLength(int[] nums) { //525
        int s = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                s++;
            } else {
                s--;
            }
            map.computeIfAbsent(s, k -> new ArrayList<>()).add(i);
        }
        s = 0;
        if (map.containsKey(0)) {
            s = map.get(0).get(map.get(0).size()-1)+1;
            map.remove(0);
        }
        int k;
        for (Integer key : map.keySet()) {
            k = map.get(key).get(map.get(key).size()-1) - map.get(key).get(0);
            if (k>s) s = k;
        }
        return s;
    }

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) { //576
        final int M = 1000000000 + 7;
        int[][] dp = new int[m][n];
        dp[startRow][startColumn] = 1;
        int count = 0;

        for (int moves = 1; moves <= maxMove; moves++) {
            int[][] temp = new int[m][n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == m - 1) count = (count + dp[i][j]) % M;
                    if (j == n - 1) count = (count + dp[i][j]) % M;
                    if (i == 0) count = (count + dp[i][j]) % M;
                    if (j == 0) count = (count + dp[i][j]) % M;
                    temp[i][j] = (
                            ((i > 0 ? dp[i - 1][j] : 0) + (i < m - 1 ? dp[i + 1][j] : 0)) % M +
                                    ((j > 0 ? dp[i][j - 1] : 0) + (j < n - 1 ? dp[i][j + 1] : 0)) % M
                    ) % M;
                }
            }
            dp = temp;
        }

        return count;
    }
}
