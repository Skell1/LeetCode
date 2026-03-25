package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_3500_3600 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_3500_3600().canPartitionGrid(new int[][]{{1,1,1}}));
        //System.out.println(new LeetCode_3500_3600().canPartitionGrid(new int[][]{{9753,4621,3652},{3003,4050,433}}));

    }

    public int minOperations(int[] nums, int k) { //3512
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum % k;

    }

    public int findClosest(int x, int y, int z) { //3516
        int diff = Math.abs(x - z) - Math.abs(y - z);
        if (diff > 0) return 2;
        else if (diff == 0) return 0;
        else return 1;
    }

    public int maxFreqSum(String s) { //3541
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        List<Character> r = List.of('a', 'e', 'i', 'o', 'u');

        return map.entrySet().stream().filter(e -> r.contains(e.getKey())).mapToInt(Map.Entry::getValue).max().orElse(0)
                +map.entrySet().stream().filter(e -> !r.contains(e.getKey())).mapToInt(Map.Entry::getValue).max().orElse(0);
    }

    public boolean canPartitionGrid(int[][] grid) { //3546
        long max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                max += grid[i][j];
            }
        }
        if (max % 2 != 0) return false;
        max /= 2;
        long current = 0;
        for (int i = 0; i < grid.length-1; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                current += grid[i][j];
            }
            if (current == max) {
                return true;
            }
            if (current > max) {
                break;
            }
        }
        current = 0;
        for (int i = 0; i < grid[0].length-1; i++) {
            for (int j = 0; j < grid.length; j++) {
                current += grid[j][i];
            }
            if (current == max) {
                return true;
            }
            if (current > max) {
                break;
            }
        }
        return false;
    }

    public int countPermutations(int[] complexity) { //3577
        long result = 0;
        for (int i = 1; i < complexity.length; i++) {
            if (complexity[i] <= complexity[0]) {
                return 0;
            }
        }
        result++;
        for (int i = 1; i < complexity.length; i++) {
            result = result * i % 1000000007 ;
        }
        return (int) (result % 1000000007);
    }

}
