package org.example;

import java.util.ArrayList;
import java.util.Objects;

public class Palindrome_Number_9 {
    public static boolean isPalindrome(int x) {
        if (x<0) return false;
        ArrayList<Integer> a = new ArrayList<>();
        while (x>0){
            a.add(x % 10);
            x = x / 10;
        }
        for (int i = 0; i < a.size()/2; i++) {
            if (!Objects.equals(a.get(i), a.get(a.size() - i - 1)))
                return false;
        }
        return true;
    }
}
