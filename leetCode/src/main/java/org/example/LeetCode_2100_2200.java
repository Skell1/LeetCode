package org.example;

import java.util.List;
import java.util.Stack;

public class LeetCode_2100_2200 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_2100_2200().replaceNonCoprimes(new int[]{31,97561,97561,97561,97561,97561,97561,97561,97561}));
    }

    public static String firstPalindrome(String[] words) {//2108
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (words[i].contentEquals(stringBuilder.append(words[i]).reverse())) {
                return words[i];
            }
            stringBuilder.setLength(0);
        }
        return "";
    }

    public List<Integer> replaceNonCoprimes(int[] nums) { //2197
        Stack<Integer> stack = new Stack<>();
        stack.push(nums[0]);
        int nod, nok;
        int peek;
        for (int i = 1; i < nums.length; i++) {

                peek = stack.peek();
                nod = findNOD(Math.max(peek, nums[i]), Math.min(peek, nums[i]));
                if (nod > 1) {
                    nok = nums[i];
                    while (true) {
                        if (stack.isEmpty()) break;
                        peek = stack.peek();
                        nod = findNOD(Math.max(peek, nok), Math.min(peek, nok));
                        if (nod == 1) {
                            break;
                        }
                        nok = peek / nod * nok ;
                        stack.pop();
                    }
                    stack.push(nok);
                } else {
                    stack.push(nums[i]);
                }

        }
        return stack;
    }

    private int findNOD(int a, int b) {
        int temp;
        while (true){
            temp = a % b;
            if (temp == 0) {
                return b;
            } else {
                a = b;
                b = temp;
            }
        }
    }

}
