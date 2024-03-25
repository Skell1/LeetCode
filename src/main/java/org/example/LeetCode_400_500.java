package org.example;

import java.util.*;

public class LeetCode_400_500 {
    public static void main(String[] args) {
        frequencySort("tree");
    }

    public List<Integer> findDuplicates(int[] nums) { //442
        int[] temp = new int[nums.length+1];
        List<Integer> list = new ArrayList<>();
        //Arrays.fill(temp,0);
        for (int num : nums) {
            temp[num]++;
            if (temp[num] == 2) list.add(num);
        }
        return list;
    }

    public static String frequencySort(String s) { //451
        Map<Character, StringBuilder> map = new HashMap<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            map.computeIfAbsent(ch, k -> new StringBuilder()).append(ch);
        }
        StringBuilder builder = new StringBuilder();
        map.values().stream().sorted((s1,s2) -> s2.length() - s1.length()).forEach(builder::append);
        return builder.toString();
    }
}
