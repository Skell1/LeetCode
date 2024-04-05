package org.example;

public class LeetCode_1500_1600 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_1500_1600().makeGood("abBAcC"));
        //1011011  5
        //11100  2
    }

    public String makeGood(String s) { //1544
        StringBuilder builder = new StringBuilder(s);
        for (int i = 0; i < builder.length()-1; i++) {
            if (builder.charAt(i) != builder.charAt(i+1) &&
                    (Character.toUpperCase(builder.charAt(i)) == builder.charAt(i+1) ||
                            Character.toLowerCase(builder.charAt(i)) == builder.charAt(i+1))) {
                builder.deleteCharAt(i+1);
                builder.deleteCharAt(i);
                i = i>0 ? i-2: i-1;
            }
        }
        return builder.toString();
    }

}
