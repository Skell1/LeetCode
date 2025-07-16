package org.example;

public class LeetCode_3200_3300 {
    public static void main(String[] args) {


         System.out.println(new LeetCode_3200_3300().maximumLength(new int[]{1,2,3,4}));
    }

    public int maximumLength(int[] nums) { //3201
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        int cc = 0;
        int dd = 1;

        int temp;
        for (int i = 0; i < nums.length; i++) {
            temp = nums[i] % 2;
            if (temp == 0) {
                a++;
            } else {
                b++;
            }
            if (temp == cc) {
                c++;
                if (cc == 0) {
                    cc = 1;
                } else cc = 0;
            }
            if (temp == dd) {
                d++;
                if (dd == 0) {
                    dd = 1;
                } else dd = 0;
            }
        }
        return Math.max(Math.max(a, b), Math.max(c, d));
    }

}
