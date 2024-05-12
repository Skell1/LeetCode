package org.example;

import org.example.util.TreeNode;

import java.util.Map;
import java.util.Set;

public class LeetCode_2300_2400 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_2300_2400().largestLocal(new int[][]{{9,9,8,1},{5,6,2,6},{8,2,6,4},{6,2,2,2}}));
    }

    public int[][] largestLocal(int[][] grid) { //2373
        int[][] result = new int[grid.length-2][grid.length-2];
        int max;
        for (int i = 1; i <= grid.length-2; i++) {
            for (int j = 1; j <= grid.length-2; j++) {
                max = grid[i-1][j-1];
                for (int k = i-1; k < i+2; k++) {
                    for (int l = j-1; l < j+2; l++) {
                        if (grid[k][l]>max) max = grid[k][l];
                    }
                }
                result[i-1][j-1] = max;
            }
        }
        return result;
    }

    public static int amountOfTime(TreeNode root, int start) {
        int toStart;
        int maxL, maxR;
        boolean isToStart = false;

        return 0;
    }

    public void convert(TreeNode current, int parent, Map<Integer, Set<Integer>> map){
        if (map.containsKey(current.val));
    }



    }
