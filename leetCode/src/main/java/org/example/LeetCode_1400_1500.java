package org.example;

public class LeetCode_1400_1500 {
    public static void main(String[] args) {
        System.out.println(maxScore("1111"));
        //1011011  5
        //11100  2
    }

    public static int maxScore(String s) { //1422
        int length = s.length();
        int result = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '1') result++;
        }
        if (result == length) return result-1;
        int current = result;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '0'){
                current++;
                if (i == length-1) continue;
                if (current > result){
                    result = current;
                }
            }
            else {
                if (i == 0) result--;
                current--;
            }
        }
        return result;

    }
}
