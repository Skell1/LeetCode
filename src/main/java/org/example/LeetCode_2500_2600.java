package org.example;

public class LeetCode_2500_2600 {
    public static void main(String[] args) {

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
