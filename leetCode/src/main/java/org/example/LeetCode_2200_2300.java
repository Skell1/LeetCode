package org.example;

import java.util.*;

public class LeetCode_2200_2300 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_2200_2300().countHillValley(new int[]{57,57,57,57,57,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,90,85,85,85,86,86,86}));
    }

    public int countHillValley(int[] nums) { //2210
        int result = 0;
        int k;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] > nums[i - 1]) {
                k = i;
                do {
                    k++;
                    if (k> nums.length-1) {
                        return result;
                    }
                } while (nums[i] == nums[k]);
                if (nums[i] > nums[k]) {
                    result++;
                    i = k-1;
                }
            } else if (nums[i] < nums[i - 1]) {
                k = i;
                do {
                    k++;
                    if (k> nums.length-1) {
                        return result;
                    }
                } while (nums[i] == nums[k]);
                if (nums[i] < nums[k]) {
                    result++;
                    i = k-1;
                }
            }
        }

        return result;
    }

    public List<List<Integer>> findWinners(int[][] matches) { //2225
        HashMap<Integer,Integer> map = new HashMap<>();
        int win,lose;
        for (int[] ints : matches) {
            win = ints[0];
            lose = ints[1];
            if (!map.containsKey(win)){
                map.put(win,0);
            }
            if (map.containsKey(lose)){
                map.put(lose, map.get(lose)+1);
            }
            else map.put(lose,1);
        }
        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();

        for (Integer key : map.keySet().stream().sorted().toList()) {
            if (map.get(key) == 0){
                first.add(key);
            }
            if (map.get(key) == 1){
                second.add(key);
            }
        }
        answer.add(first);
        answer.add(second);
        return answer;
    }

}
