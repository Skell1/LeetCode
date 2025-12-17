package org.example;

import java.util.List;
import java.util.Stack;

public class LeetCode_2100_2200 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_2100_2200().numberOfWays("PPPPPPPSPPPSPPPPSPPPSPPPPPSPPPSPPSPPSPPPPPSPSPPPPPSPPSPPPPPSPPSPPSPPPSPPPPSPPPPSPPPPPSPSPPPPSPSPPPSPPPPSPPPPPSPSPPSPPPPSPPSPPSPPSPPPSPPSPSPPSSSS"));
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

    public int numberOfWays(String corridor) { //2147
        char[] chars = corridor.toCharArray();
        long result = 1;
        int curr = 0;
        int temp = 0;
        int countS = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'S') {
                countS++;
                if (curr < 2) {
                    curr++;
                } else {
                    curr = 1;
                    if (temp != 0) {
                        result = (result * (temp + 1)) % 1000000007;
                        temp = 0;
                    }
                }
            } else {
                if (curr == 2) {
                    temp++;
                }
            }
        }
        if (countS < 2 || countS % 2 == 1) {
            return 0;
        }
        return (int) result;

    }
    // 5*6*3*6*6*6*3*5*6*5*4*6*3*3*3*3*3
    public int findFinalValue(int[] nums, int original) { //2154
        int i = 0;
        while (i<nums.length) {
            if (nums[i] == original) {
                original = original * 2;
                i = -1;
            }
            i++;
        }
        return original;
    }

    public int countOperations(int num1, int num2) { //2169
        int count = 0;
        while (num1 != 0 && num2 != 0) {
            if (num1 > num2) {
                num1 -= num2;
            } else {
                num2 -= num1;
            }
            count++;
        }
        return count;
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
