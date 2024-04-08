package org.example;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_1700_1800 {
    public static void main(String[] args) {

        System.out.println(new LeetCode_1700_1800().countStudents(new int[]{1,1,1,0,0,1},new int[]{1,0,0,0,1,1}));
    }

    public int countStudents(int[] students, int[] sandwiches) { //1700
        List<Integer> list = new ArrayList<>();
        for (int student : students) {
            list.add(student);
        }
        for (int i = 0; i < sandwiches.length; i++) {
            if (list.contains(sandwiches[i])) list.remove(list.indexOf(sandwiches[i]));
            else return list.size();
        }
        return 0;

    }

    public static int minimumLength(String s) { //1750
        StringBuilder builder = new StringBuilder(s);
        while (builder.length()>1 && builder.charAt(0) == builder.charAt(builder.length()-1)) {
            char c = builder.charAt(0);
            while (builder.length()>2 && builder.charAt(1) == c) {
                builder.deleteCharAt(1);
            }
            while (builder.length()-2>0 && builder.charAt(builder.length()-2) == c) {
                builder.deleteCharAt(builder.length()-2);
            }
            builder.deleteCharAt(0);
            builder.deleteCharAt(builder.length()-1);
        }
        return builder.length();
    }

    public static int totalMoney(int n) { //1716
        int k = 0;
        int week = 1;
        for (int i = 0; i < n;) {
            for (int j = week; j < 7 + week && i < n; j++, i++ ){
                k += j;
            }
            week++;
        }
        return k;
    }

    public static int minOperations(String s) { //1758
        int k0 = 0, k1 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0){
                if (s.charAt(i) == '1')
                    k0++;
                else k1++;
            }
            else {
                if (s.charAt(i) == '1')
                    k1++;
                else k0++;
            }
        }
        return Math.min(k0, k1);
    }
}
