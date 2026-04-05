package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_600_700 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_600_700().countBinarySubstrings("00110"));
    }

    public int triangleNumber(int[] nums) { //611
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i]+nums[j]>nums[k]) {
                        sum++;
                    } else {
                        break;
                    }
                }
            }
        }
        return sum;
    }

    public boolean judgeCircle(String moves) { //657
        int countR = 0;
        int countU = 0;

        for (char c : moves.toCharArray()) {
            if (c == 'R') {
                countR++;
            } else if (c == 'L') {
                countR--;
            } else if (c == 'U') {
                countU++;
            } else if (c == 'D') {
                countU--;
            }
        }
        return countR == 0 && countU == 0;
    }

    public static int[][] imageSmoother(int[][] img) { //661
        int x = img.length;
        int y = img[0].length;
        int[][] result = new int[x][y];
        int a;
        int count;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                a = img[i][j];
                count = 1;
                if (i>0) {
                    a+= img[i-1][j];
                    count++;
                    if (j>0) {
                        a += img[i - 1][j - 1];
                        count++;
                    }
                    if (j<y-1) {
                        a += img[i - 1][j + 1];
                        count++;
                    }
                }
                if (i<x-1){
                    a+=img[i+1][j];
                    count++;
                    if (j>0) {
                        a += img[i + 1][j - 1];
                        count++;
                    }

                    if (j<y-1) {
                        a += img[i + 1][j + 1];
                        count++;
                    }

                }

                if (j>0) {
                    a+= img[i][j-1];
                    count++;
                }
                if (j<y-1){
                    a+=img[i][j+1];
                    count++;
                }
                result[i][j]= a/count;

            }

        }
        System.gc();
        return result;
    }

    public boolean hasAlternatingBits(int n) { //693
        long curr = 1;
        if (n % 2 == 0) {
            curr = 2;
        }

        while (n > 0 && n >= curr) {
            n -= curr;
            curr *= 4;
        }
        return n == 0;
    }

    public int countBinarySubstrings(String s) { //696
        List<Integer> list = new ArrayList<>();
        char c = s.charAt(0);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count++;
            } else {
                list.add(count);
                count = 1;
                c = s.charAt(i);
            }
        }
        list.add(count);
        int result = 0;
        for (int i = 0; i < list.size()-1; i++) {
            result += Math.min(list.get(i), list.get(i + 1));
        }
        return result;
    }

}
