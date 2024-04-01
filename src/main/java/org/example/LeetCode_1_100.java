package org.example;

import java.util.*;

public class LeetCode_1_100 {
    public static void main(String[] args) {
//        System.out.println(mySqrt(4));
//        System.out.println(mySqrt(8));
        System.out.println(new LeetCode_1_100().insert(new int[][]{{1,5},{6,8}}, new int[]{3,7}));

        System.out.println(new LeetCode_1_100().insert(new int[][]{{1,5}}, new int[]{0,0}));

        System.out.println(new LeetCode_1_100().insert(new int[][]{{1,5}}, new int[]{0,3}));

        System.out.println(new LeetCode_1_100().insert(new int[][]{{1,5}}, new int[]{1,7}));

        System.out.println(new LeetCode_1_100().insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4,8}));


    }

    public int lengthOfLastWord(String s) { //58
        String[] array = s.split(" ");
        return array[array.length-1].length();
    }

        public int[][] insert(int[][] intervals, int[] newInterval) { //57
        List<int[]> list = new ArrayList<>();
        if (intervals.length == 0){
            int[][] result = new int[1][];
            result[0] = newInterval;
            return result;
        }
        int a,b;
        int end = -1,start = -1;
        int[] temp;
        int[] nev = null;
            for (int[] interval : intervals) {
                a = interval[0];
                b = interval[1];
                temp = interval;
                if (a < newInterval[0] && b < newInterval[0]) {
                } else if (a < newInterval[0]) {
                    end = Math.max(b, newInterval[1]);
                    start = a;
                    temp[0] = start;
                    temp[1] = end;
                    nev = temp;
                } else if (b < newInterval[1]) {
                    if (nev != null) {
                        if (b > nev[1]) {
                            nev[1] = b;
                            list.remove(list.size() - 1);
                            list.add(nev);
                        }
                        continue;
                    } else {
                        temp[0] = newInterval[0];
                        temp[1] = newInterval[1];
                        nev = temp;
                    }

                } else {
                    if (nev != null) {
                        if (a <= nev[1]) {
                            nev[1] = b;
                            list.remove(list.size() - 1);
                            list.add(nev);
                            continue;
                        }
                    } else {
                        if (a > newInterval[1]) {
                            list.add(newInterval);
                            nev = newInterval;
                        } else {
                            temp[0] = newInterval[0];
                            nev = temp;
                        }
                    }
                }
                list.add(temp);
            }
        if (nev == null){
            list.add(newInterval);
        }
        return list.toArray(new int[0][]);
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
