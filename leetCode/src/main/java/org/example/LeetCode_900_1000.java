package org.example;

import org.example.util.TreeNode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LeetCode_900_1000 {


    public static void main(String[] args) {
        System.out.println(new LeetCode_900_1000().sumSubarrayMins(new int[]{11,81,94,43,3}));
    }
    private final int MOD = 1000000007;

    public static int sumSubarrayMins(int[] arr) { //907

        int MOD = 1000000007;
            int n = arr.length;
            Stack<Integer> s1 = new Stack<>();
            Stack<Integer> s2 = new Stack<>();
            long[] left = new long[n];
            long[] right = new long[n];

            // Calculate left boundaries
            for (int i = 0; i < n; ++i) {
                while (!s1.isEmpty() && arr[s1.peek()] > arr[i]) {
                    s1.pop();
                }
                left[i] = s1.isEmpty() ? i + 1 : i - s1.peek();
                s1.push(i);
            }

            // Calculate right boundaries
            for (int i = n - 1; i >= 0; --i) {
                while (!s2.isEmpty() && arr[s2.peek()] >= arr[i]) {
                    s2.pop();
                }
                right[i] = s2.isEmpty() ? n - i : s2.peek() - i;
                s2.push(i);
            }

            // Calculate the final sum
            long result = 0;
            for (int i = 0; i < n; ++i) {
                result = (result + arr[i] * left[i] * right[i]) % MOD;
            }

            return (int) result;
    }

    public static int minFallingPathSum(int[][] matrix) { //931
        int length = matrix.length;
        int a,b,c;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < length; j++) {
                b = matrix[i-1][j] + matrix[i][j];
                if (j>0){
                    a = matrix[i-1][j-1] + matrix[i][j];
                }
                else a = b + 1;
                if (j<length-1){
                    c = matrix[i-1][j+1]+ matrix[i][j];
                }
                else c = b + 1;
                matrix[i][j] =  Stream.of(a, b, c).min(Integer::compareTo).get();
            }
        }
        a = matrix[length-1][0];
        for (int i = 1; i < length; i++) {
            if (matrix[length-1][i] < a)
                a = matrix[length-1][i];
        }
        return a;
    }
}
