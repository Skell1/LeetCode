package org.example;

import java.util.*;

public class LeetCode_500_600 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_500_600().findRelativeRanks(new int[]{5,4,3,2,1}));
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
}
