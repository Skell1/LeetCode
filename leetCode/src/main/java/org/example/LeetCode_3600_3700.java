package org.example;

import java.util.*;

public class LeetCode_3600_3700 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_3600_3700().countTrapezoids(new int[][]{{}}));

    }

    public int countTrapezoids(int[][] points) { //3623
        long res = 0;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] point : points) {
            map.computeIfAbsent(point[1], k -> new HashSet<>()).add(point[0]);
        }

        List<Long> values = new ArrayList<>();
        long curr;
        for (Set<Integer> set  : map.values()) {
            curr = set.size();
            if (curr < 2) continue;
            values.add(curr * (curr - 1) / 2);
        }

//        int i,j;
//        for (i = 0; i < values.size() - 1; i++) {
//            curr = values.get(i);
//            for (j = i + 1; j < values.size(); j++) {
//                res = (res + curr *values.get(j)) ;
//            }
//        }

        long sum = 0;
        long totalPairs = 0;

        for (long val : values) {
            totalPairs = (totalPairs + sum * val) % (1000000000 + 7); // Добавляем произведения с предыдущими значениями
            sum += val;              // Обновляем накопленную сумму
        }

        return (int) totalPairs;

    }
}
