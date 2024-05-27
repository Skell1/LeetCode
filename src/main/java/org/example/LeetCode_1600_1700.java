package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_1600_1700 {
    public static void main(String[] args) {
        new LeetCode_1600_1700().specialArray(new int[]{3,6,7,7,0});
    }

    public int specialArray(int[] nums) { //1608
        Arrays.sort(nums);
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (res<=nums[i] && (i==0 || res>nums[i-1])) return res;
            else res--;
        }
        return -1;
    }

    public int maxDepth(String s) { //1614
        int max = 0;
        int curr = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                curr++;
            } else if (ch == ')') {
                if (curr>max) max = curr;
                curr--;
            }
        }
        return max;
    }

    public boolean closeStrings(String word1, String word2) { //1657
        if (word1.length()!=word2.length()) return false;
        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for (char ch : word1.toCharArray()) {
            count1[ch - 'a']++;
        }

        for (char ch : word2.toCharArray()) {
            count2[ch - 'a']++;
        }

        if (count1.equals(count2)) return true;

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        Integer a,b;
        for (int i = 0; i < count1.length; i++) {
            a = count1[i];
            b = count2[i];
            if (a != b) {
                if (a==0 || b==0) return false;
                if (list1.contains(b)){
                    list1.remove(b);
                }
                else {
                    list2.add(b);
                }
                if (list2.contains(a)){
                    list2.remove(a);
                }
                else {
                    list1.add(a);
                }
            }
        }
        if (list1.isEmpty() && list2.isEmpty()) return true;
        return false;
    }

}
