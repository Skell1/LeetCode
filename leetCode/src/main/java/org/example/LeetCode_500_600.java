package org.example;

public class LeetCode_500_600 {
    public static void main(String[] args) {
        //   System.out.println(findPaths(2,2,  2,  0,  0));
        System.out.println(findPaths(4,5,  4,  1,  2));
        //System.out.println(findPaths(1,2,  50,  0,  1));


    }

    public static int findPaths(int m, int n, int maxMove, int startRow, int startColumn) { //576
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
