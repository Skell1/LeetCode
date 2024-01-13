package org.example;

public class LeetCode_1300_1400 {
    public static void main(String[] args) {
    }

    public static int minSteps(String s, String t) { //1347
        StringBuilder builder = new StringBuilder(t.length());
        builder.append(t);
        String ch;
        int index;
        for (int i = 0; i < s.length(); i++) {
            ch = String.valueOf(s.charAt(i));
            index = builder.indexOf(ch);
            if (index>=0)
                builder.deleteCharAt(index);
        }
        System.gc();
        return builder.length();
    }
}
