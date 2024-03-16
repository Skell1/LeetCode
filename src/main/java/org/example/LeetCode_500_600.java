package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_500_600 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_500_600().findMaxLength(new int[]{0,1,0,1}));
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
