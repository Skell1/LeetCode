package org.example;

import java.util.*;

public class LeetCode_400_500 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_400_500().removeKdigits("1234567890", 9));
    }

    public String removeKdigits(String num, int k) { //402
        StringBuilder sb = new StringBuilder(num);
        for (int i = 0; i < sb.length()-1 && k>0; i++) {
            if (sb.charAt(i)>sb.charAt(i+1)) {
                sb.deleteCharAt(i);
                i-=2;
                if (i<-1) i = -1;
                k--;
            }
        }
        System.out.println(sb);
        while (k>0 && sb.length()>0) {
            sb.deleteCharAt(sb.length()-1);
            k--;
        }
        while (sb.length()>0 && sb.charAt(0) == '0' ){
            sb.deleteCharAt(0);
        }
        if (sb.length()==0) return "0";
        return sb.toString();
    }

    public List<Integer> findDuplicates(int[] nums) { //442
        int[] temp = new int[nums.length+1];
        List<Integer> list = new ArrayList<>();
        //Arrays.fill(temp,0);
        for (int num : nums) {
            temp[num]++;
            if (temp[num] == 2) list.add(num);
        }
        return list;
    }

    public static String frequencySort(String s) { //451
        Map<Character, StringBuilder> map = new HashMap<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            map.computeIfAbsent(ch, k -> new StringBuilder()).append(ch);
        }
        StringBuilder builder = new StringBuilder();
        map.values().stream().sorted((s1,s2) -> s2.length() - s1.length()).forEach(builder::append);
        return builder.toString();
    }
}
