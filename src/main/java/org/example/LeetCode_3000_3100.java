package org.example;

public class LeetCode_3000_3100 {
    public static void main(String[] args) {
        System.out.println(maxFrequencyElements( new int[]{3,4,2}));
    }

    public static int maxFrequencyElements(int[] nums) { //3005
        int[] array = new int[101];
        for (int i = 0; i < array.length; i++) {
            array[i] = 0;
        }

        for (int i = 0; i < nums.length; i++) {
            array[nums[i]] += 1;
        }
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) max = array[i];
        }
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == max) count++;
        }
        return max*count;
    }
}
