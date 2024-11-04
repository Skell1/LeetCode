package org.example;

public class LeetCode_3100_3200 {
    public static void main(String[] args) {

        System.out.println(new LeetCode_3100_3200());
    }

    public int scoreOfString(String s) { //3110
        int res = 0;
        for (int i = 0; i < s.length()-1; i++) {
            res += Math.abs(s.charAt(i) - s.charAt(i+1));
        }
        return res;
    }

    public String compressedString(String word) { //3163
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char ch = word.charAt(0);
        for (int i = 1; i < word.length(); i++) {
            if (ch == word.charAt(i)) {
                count++;
                if (count > 8) {
                    sb.append(count).append(ch);
                    count = 0;
                }
            } else {
                if (count > 0) sb.append(count).append(ch);
                count = 1;
                ch = word.charAt(i);
            }
        }
        if (count > 0) sb.append(count).append(ch);
        return sb.toString();
    }
}
