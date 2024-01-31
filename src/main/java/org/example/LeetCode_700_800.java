package org.example;

import java.util.Stack;

public class LeetCode_700_800 {
    public static void main(String[] args) {
//        System.out.println(kthGrammar(7,12));
//        System.out.println(kthGrammarOld(7,12));
        System.out.println(dailyTemperatures(new int[]{73,74,75,71,69,72,76,73}));
    }

    public static int[] dailyTemperatures(int[] temperatures) { //739
        //Stack<Integer> stack = new Stack<>();
        Stack<Integer> ind = new Stack<>();
        int[] answ = new int[temperatures.length];
        int temp;
        int index;

        for (int i = 0; i < temperatures.length; i++) {
            temp = temperatures[i];
            while (!ind.empty() && temperatures[ind.peek()]<temp) {
                index = ind.pop();
                answ[index] = i - index;
            }
            ind.push(i);
        }
        while (!ind.empty()) {
            temperatures[ind.pop()] = 0;
        }
        return answ;
    }

    public static int kthGrammar(int n, int k) { //779
        System.out.println(n + "  " + k);

        if (n == 1) return 0;
        if (k==3) return 0;
        if (k <= 2) {
            //System.out.println(n + "  " + k);
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
            //System.out.println(builderNew);
            builderOld.setLength(0);
            builderOld.append(builderNew);
            builderNew.setLength(0);
        }
        System.out.println(builderOld);
        //System.out.println((k+n) % 2);
        if (builderOld.charAt(k-1) == '0'){
            return 0;
        }
        else return 1;
    }
}
