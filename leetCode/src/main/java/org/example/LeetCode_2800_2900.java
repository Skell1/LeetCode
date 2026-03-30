package org.example;

import java.util.*;

public class LeetCode_2800_2900 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_2800_2900().checkStrings("abcdba", "cabdab"));
    }

    public boolean canBeEqual(String s1, String s2) { //2839
        return ((s1.charAt(0) == s2.charAt(0) && s1.charAt(2) == s2.charAt(2)) || (s1.charAt(0) == s2.charAt(2) && s1.charAt(2) == s2.charAt(0)))
                &&
                ((s1.charAt(1) == s2.charAt(1) && s1.charAt(3) == s2.charAt(3)) || (s1.charAt(1) == s2.charAt(3) && s1.charAt(3) == s2.charAt(1)));
    }

    public boolean checkStrings(String s1, String s2) { //2840
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            if (i % 2 == 0) {
                map1.put(s1.charAt(i), map1.getOrDefault(s1.charAt(i), 0) + 1);
            } else {
                map2.put(s1.charAt(i), map2.getOrDefault(s1.charAt(i), 0) + 1);
            }
        }
        int a;
        for (int i = 0; i < s2.length(); i++) {
            if (i % 2 == 0) {
                if (map1.containsKey(s2.charAt(i)) && map1.get(s2.charAt(i))>0) {
                    a = map1.get(s2.charAt(i))-1;
                    if (a==0) {
                        map1.remove(s2.charAt(i));
                    } else {
                        map1.put(s2.charAt(i), a);
                    }
                } else {
                    return false;
                }

            } else {
                if (map2.containsKey(s2.charAt(i)) && map2.get(s2.charAt(i))>0) {
                    a = map2.get(s2.charAt(i))-1;
                    if (a==0) {
                        map2.remove(s2.charAt(i));
                    } else {
                        map2.put(s2.charAt(i), a);
                    }
                } else {
                    return false;
                }
            }
        }
        return map1.isEmpty() && map2.isEmpty();

    }
}
