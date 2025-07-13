package org.example;

import java.util.Arrays;

public class LeetCode_2400_2500 {
    public static void main(String[] args) {

    }

    public int matchPlayersAndTrainers(int[] players, int[] trainers) { //2410
        Arrays.sort(players);
        Arrays.sort(trainers);

        int k = 0;
        int count = 0;
        for (int i = 0; i < players.length; i++) {
            for (int j = k; j < trainers.length; j++) {
                if (players[i] <= trainers[j]) {
                    k = j+1;
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public int[] applyOperations(int[] nums) { //2460
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == nums[i+1]) {
                nums[i] *= 2;
                nums[i+1] = 0;
            }
        }
        int[] res = new int[nums.length];
        int k=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                res[k] = nums[i];
                k++;
            }
        }
        return res;
    }



}
