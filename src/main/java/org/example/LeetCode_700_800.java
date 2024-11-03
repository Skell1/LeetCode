package org.example;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode_700_800 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_700_800().rotateString("abcde", "cdeab"));
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) { //713
        int count = 0;
        int s;
        for (int i = 0; i < nums.length; i++) {
            s = nums[i];
            if (s<k) count++;
            for (int j = i+1; j < nums.length; j++) {
                s *= nums[j];
                if (s< k ) count++;
                else break;
            }
        }
        return count;
    }

    public static int[] dailyTemperatures(int[] temperatures) { //739
        Deque<Integer> ind = new ArrayDeque<>();
        int[] answ = new int[temperatures.length];
        int temp;
        int index;

        for (int i = 0; i < temperatures.length; i++) {
            temp = temperatures[i];
            while (!ind.isEmpty() && temperatures[ind.peek()]<temp) {
                index = ind.pop();
                answ[index] = i - index;
            }
            ind.push(i);
        }
        while (!ind.isEmpty()) {
            temperatures[ind.pop()] = 0;
        }
        return answ;
    }

    public static int kthGrammar(int n, int k) { //779
        System.out.println(n + "  " + k);

        if (n == 1) return 0;
        if (k==3) return 0;
        if (k <= 2) {
            if (k==1) return 0;
            else return 1;
        }
        return kthGrammar(n-1,(k+1)/2);

    }
    public static int kthGrammarOld(int n, int k) { //779
        StringBuilder builderOld = new StringBuilder().append('0');
        StringBuilder builderNew = new StringBuilder();
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < builderOld.length(); j++) {
                builderNew.append(builderOld.charAt(j));
                if (builderOld.charAt(j) == '0'){
                    builderNew.append('1');
                }
                else builderNew.append('0');
            }
            builderOld.setLength(0);
            builderOld.append(builderNew);
            builderNew.setLength(0);
        }
        System.out.println(builderOld);
        if (builderOld.charAt(k-1) == '0'){
            return 0;
        }
        else return 1;
    }

    public boolean rotateString(String s, String goal) { //796
        if (s.length() != goal.length()) return false;
        if (s.equals(goal)) return true;
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < goal.length(); i++) {
            sb.append(sb.charAt(0));
            sb.deleteCharAt(0);
            if (sb.toString().equals(goal)) return true;
        }
        return false;

        //best
//        if(s.length()!=goal.length())
//            return false;
//        String str=s+s;
//        if(str.contains(goal))
//            return true;
//        return false;
    }
}
