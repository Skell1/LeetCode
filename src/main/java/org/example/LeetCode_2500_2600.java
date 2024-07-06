package org.example;

public class LeetCode_2500_2600 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_2500_2600().passThePillow(18,38 )); //5

        System.out.println(new LeetCode_2500_2600().passThePillow(4,5 ));//2
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

    public int passThePillow(int n, int time) { //2582
        if (time < n) return time+1;
        int circl = time / (n-1);
        int count =  time - circl*(n-1);

        if (circl % 2 == 0) {
            return count;
        } else {
            return n - count;
        }

    }
}
