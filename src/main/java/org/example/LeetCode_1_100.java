package org.example;

import java.util.*;

public class LeetCode_1_100 {
    public static void main(String[] args) {
//        System.out.println(mySqrt(4));
//        System.out.println(mySqrt(8));
        System.out.println(mySqrt(2147395599));


    }

    public static List<List<String>> groupAnagrams(String[] strs) { //49
        Map<String, List<String>> map = new HashMap<>();
//        StringBuilder builder = new StringBuilder();
        String buld;
        //  ArrayList<String> list1 = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
//            for (char ch : chars) {
//                builder.append(ch).append("-");
//            }
//            buld = builder.toString();
            buld = new String(chars);
            map.computeIfAbsent(buld, k -> new ArrayList<>()).add(strs[i]);
//            if (map.containsKey(buld)) {
//                map.get(buld).add(strs[i]);
//            }
//            else {
//                list1 = new ArrayList<>();
//                list1.add(strs[i]);
//                map.put(builder.toString(), list1);
//            }
//            builder.setLength(0);
        }
//        List<List<String>> result = new ArrayList<>();
//        for (List<String> list : map.values()) {
//            result.add(list);
//        }
//        return result;
        return new ArrayList<List<String>>(map.values());
    }

    public static int mySqrt(int x) { //69
        if(x <= 1) {
            return x;
        }
        int start = 1, end = (x/2)+1, sqrt = 0;
        long mid = 0;

        while(start <= end) {
            mid = (start+end)/2;
            if(mid*mid == x) {
                return (int) mid;
            } else if(mid*mid < x) {
                start = (int) mid + 1;
                sqrt = (int) mid;
            } else {
                end = (int) mid - 1;
            }
        }

        return sqrt;

    }
    public int climbStairs(int n) { //70
        if (n==1) return 1;
        if (n==2) return 2;
        int[] a = new int[n];
        a[0] =  1;
        a[1] = 2;
        for (int i = 2; i < n; i++) {
            a[i] = a[i-1] + a[i-2];
        }
        return a[n-1];
    }
}
