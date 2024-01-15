package org.example;

import java.util.*;

public class LeetCode_2200_2300 {
    public static void main(String[] args) {
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
