package org.example;

public class LeetCode_1200_1300 {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,12,12,12};
        System.out.println(findSpecialInteger(a));
        System.out.println(findSpecialInteger(new int[]{1,2,2,6,6,6,6,7,10}));
    }

    public static int findSpecialInteger(int[] arr) { //1287
        int aa = arr.length/4;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == arr[i+aa]){
                System.gc();
                return arr[i];
            }
        }
        return 0;
    }
}
