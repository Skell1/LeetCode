package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_3500_3600 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_3500_3600().countPermutations(new int[]{38,223,100,123,406,234,256,93,222,259,233,69,139,245,45,98,214}));

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
