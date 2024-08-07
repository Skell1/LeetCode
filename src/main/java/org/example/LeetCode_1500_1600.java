package org.example;

import java.util.Arrays;

public class LeetCode_1500_1600 {
    public static void main(String[] args) {
        //System.out.println(new LeetCode_1500_1600().maxDistance(new int[]{1,2,3,4,5,6,7,8,9,10}, 4));
        System.out.println(new LeetCode_1500_1600().minDifference(new int[]{1,5,0,10,14}));

        //   System.out.println(new LeetCode_1500_1600().maxDistance(new int[]{79,74,57,22}, 4));

     //   System.out.println(new LeetCode_1500_1600().maxDistance(new int[]{1,2,3,4,7}, 3));
        //System.out.println(new LeetCode_1500_1600().maxDistance(new int[]{5,4,3,2,1,1000000000}, 2));

        //1011011  5
        //11100  2
    }

    public int minDifference(int[] nums) { //1509
        if (nums.length <= 4 ) return 0;
        Arrays.sort(nums);
        return Math.min(
                Math.min(nums[nums.length-1] - nums[3],nums[nums.length-2] - nums[2]),
                Math.min(nums[nums.length-3] - nums[1],nums[nums.length-4] - nums[0]));

    }

    public String makeGood(String s) { //1544
        StringBuilder builder = new StringBuilder(s);
        for (int i = 0; i < builder.length()-1; i++) {
            if (builder.charAt(i) != builder.charAt(i+1) &&
                    (Character.toUpperCase(builder.charAt(i)) == builder.charAt(i+1) ||
                            Character.toLowerCase(builder.charAt(i)) == builder.charAt(i+1))) {
                builder.deleteCharAt(i+1);
                builder.deleteCharAt(i);
                i = i>0 ? i-2: i-1;
            }
        }
        return builder.toString();
    }

    public int maxDistance(int[] position, int m) { //1552
        Arrays.sort(position);
        int max = position[position.length-1];
        int min = 0;
        int diff = (max+min)/2;
        int curi,nexti;
        int count;
        int bin = 0, currbin;
        while (min < max) {
            curi = position[0];
            count=1;
            currbin = position[position.length-1];
            for (int i = 1; i < position.length; i++) {
                nexti = position[i];
                if (nexti - curi >= diff) {
                    count++;
                    if (nexti - curi < currbin) {
                        currbin = nexti- curi;
                    }
                    curi = nexti;
                }
            }
            if (count >= m) {
                min = diff + 1;
                diff = (max + min) / 2;
                if (currbin >= bin) {
                    bin = currbin;
                }
            } else {
                max = diff;
                diff = (max + min) / 2;
            }

        }
        return bin;
    }

    public int minOperations(String[] logs) {//1598
        int count = 0;
        for (String log : logs) {
            if (log.equals("../")) {
                if (count > 0) count--;
            } else if (log.equals("./")) {

            } else  {
                count++;
            }
        }
        return count;
    }

}
