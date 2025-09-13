package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_3500_3600 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_3500_3600().findClosest(2,7,4));

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

}
