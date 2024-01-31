package org.example;

public class A953 {
    public static boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < words.length-1; i++) {
            char[] a = words[i].toCharArray();
            char[] b = words[i+1].toCharArray();
            int c = a.length < b.length? a.length : b.length;

            for (int j = 0; j < c; j++) {
                int q = order.indexOf(a[j]);
                int w = order.indexOf(b[j]);
                if (q<w){
                    break;
                }
                if (q>w){
                    return false;
                }
                if (j==c-1 && a.length>b.length) return false;
            }
        }
        return true;
    }
}
