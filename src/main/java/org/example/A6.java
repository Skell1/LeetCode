package org.example;

public class A6 {
    public static String convert(String s, int numRows) {
        if (numRows==1 ) return s;
        char[] chars = s.toCharArray();
        int n = (numRows-1)*2;
        StringBuilder a = new StringBuilder();
        for (int i = 1; i < numRows-1; i++) {
            int k = i;
            int l = n-i;
            while (k<chars.length || l < chars.length){
                if (k< chars.length) {
                    a.append(chars[k]);
                }
                if (l< chars.length) {
                    a.append(chars[l]);
                }
                k+=n;
                l+=n;
            }
        }
        int k = 0;
        StringBuilder s1 = new StringBuilder();
        while (k<chars.length){
            s1.append(chars[k]);
            if (k+numRows-1< chars.length) {
                a.append(chars[k + numRows - 1]);
            }
            k += n;
        }
        return s1.toString() +a;
    }
}
