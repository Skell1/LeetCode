package org.example;

import org.example.util.TreeNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LeetCode_2300_2400 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_2300_2400().canChange("_L__R__R_", "L______RR"));
    }

    public boolean canChange(String start, String target) { //2337
        Map<Integer, Character> map = new HashMap<>();
        Map<Integer, Character> map2 = new HashMap<>();

        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) == 'L' || start.charAt(i) == 'R') {
                map.put(i, start.charAt(i));
            }
            if (target.charAt(i) == 'L' || target.charAt(i) == 'R') {
                map2.put(i, target.charAt(i));
            }
        }

        if (map.size() != map2.size()) return false;

        List<Integer> keys = map.keySet().stream().sorted().toList();
        List<Integer> keys2 = map2.keySet().stream().sorted().toList();

        for (int i = 0; i < keys.size(); i++) {
            if (map.get(keys.get(i)) != map2.get(keys2.get(i))) return false;
            if (map.get(keys.get(i)) == 'L' && keys.get(i) < keys2.get(i)) return false;
            if (map.get(keys.get(i)) == 'R' && keys.get(i) > keys2.get(i)) return false;
        }
        return true;
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
