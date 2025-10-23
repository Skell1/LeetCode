package org.example;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_3400_3500 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_3400_3500().hasSameDigits("545"));

    }

    public boolean hasSameDigits(String s) { //3461
        StringBuilder sb = new StringBuilder();
        while (s.length() >2) {
            for (int i = 0; i < s.length()-1; i++) {
                int a = (s.charAt(i) + s.charAt(i+1) - '0' - '0') % 10;
                sb.append(a);
            }
            s = sb.toString();
            sb = new StringBuilder();
        }
        return s.charAt(0) == s.charAt(1);
    }

}
