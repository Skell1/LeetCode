package org.example;

import java.util.*;

public class LeetCode_2200_2300 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_2200_2300().triangularSum(new int[]{2,6,6,5,5,3,3,8,6,4,3,3,5,1,0,1,3,6,9}));
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

    public int triangularSum(int[] nums) { //2221
        int[] result = new int[nums.length];
        int length = nums.length;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = 0; j < length-1; j++) {
                result[j] = (nums[j] + nums[j + 1]) % 10;
            }
            length--;
            System.out.println(Arrays.toString(result));
            nums = result;
        }
        return nums[0];
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

    public List<String> removeAnagrams(String[] words) { //2273
        List<String> result = new ArrayList<>(List.of(words));
        char[] a,b;
        for (int i = 1; i < result.size(); i++) {
            if (result.get(i).length() == result.get(i-1).length()) {
                a = result.get(i).toCharArray();
                b = result.get(i-1).toCharArray();
                Arrays.sort(a);
                Arrays.sort(b);
                if (Arrays.equals(a,b)) {
                    result.remove(i);
                    i--;
                }
            }
        }
        return result;

    }

}
