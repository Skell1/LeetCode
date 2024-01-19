package org.example;

import org.example.util.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LeetCode_900_1000 {


    public static void main(String[] args) {
        minFallingPathSum(new int[][] {{2,1,3},{6,5,4},{7,8,9}});
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
