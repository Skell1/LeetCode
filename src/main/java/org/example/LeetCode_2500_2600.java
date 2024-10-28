package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCode_2500_2600 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_2500_2600().longestSquareStreak(new int[]{4,3,6,16,8,2}));
    }

    public int longestSquareStreak(int[] nums) { //2501

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        Set<Integer> sett = set.stream().sorted().collect(Collectors.toCollection(LinkedHashSet::new));
        int max = 0;
        int maxMax = 0;
        int temp;
        while (!sett.isEmpty()) {
            temp = sett.iterator().next();
            sett.remove(temp);
            while (sett.contains(temp * temp)) {
                if (max == 0) {
                    max = 2;
                } else max++;
                sett.remove(temp * temp);
                temp = temp * temp;
            }

            if (max > maxMax) maxMax = max;
            max = 0;
        }
        return maxMax == 0 ? -1 : maxMax;

    }

    public int getCommon(int[] nums1, int[] nums2) { //2540
        int a = 0;
        int b = 0;

        while (a<nums1.length && b<nums2.length) {
            if (nums1[a] == nums2[b]) return nums1[a];
            if (nums1[a] > nums2[b]) b++;
            else a++;
        }
        return -1;
    }
}
