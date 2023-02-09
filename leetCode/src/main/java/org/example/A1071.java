package org.example;

public class A1071 {
    public static String gcdOfStrings(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int l = Math.min(s1.length,s2.length);
        StringBuilder a = new StringBuilder();
        int k = 0;
        while (k<l && s1[k] == s2[k]){
            a.append(s1[k]);
            k++;
        }

        for (int i = 0; i < k; i++) {
            if (str1.replaceAll(a.toString(),"").length()==0 && str2.replaceAll(a.toString(),"").length()==0){
                return a.toString();
            }
            a = new StringBuilder(a.substring(0, a.length() - 1));
        }
        return "";
    }
}
