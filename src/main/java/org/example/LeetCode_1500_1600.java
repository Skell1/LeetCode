package org.example;

import java.util.Arrays;

public class LeetCode_1500_1600 {
    public static void main(String[] args) {
        //System.out.println(new LeetCode_1500_1600().maxDistance(new int[]{1,2,3,4,5,6,7,8,9,10}, 4));
        System.out.println(new LeetCode_1500_1600().maxDistance(new int[]{94,95,37,30,67,7,5,44,26,55,42,28,97,19,100,74,13,88,18}, 7));

        //   System.out.println(new LeetCode_1500_1600().maxDistance(new int[]{79,74,57,22}, 4));

     //   System.out.println(new LeetCode_1500_1600().maxDistance(new int[]{1,2,3,4,7}, 3));
        //System.out.println(new LeetCode_1500_1600().maxDistance(new int[]{5,4,3,2,1,1000000000}, 2));

        //1011011  5
        //11100  2
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

}
