package org.example;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_1700_1800 {
    public static void main(String[] args) {

        System.out.println(new LeetCode_1700_1800().averageWaitingTime(new int[][]{{5,2},{5,4},{10,3},{20,1}}));
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

    public double averageWaitingTime(int[][] customers) { //1701
        double sum = 0;
        int curr = customers[0][0];
        for (int[] customer : customers) {
            if (customer[0]>curr) curr = customer[0];
            curr += customer[1];
            System.out.println(curr-customer[0]);
            sum += curr-customer[0];
        }
        return sum/customers.length;
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
