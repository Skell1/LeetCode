package org.example;

public class LeetCode_700_800 {
    public static void main(String[] args) {
        System.out.println(kthGrammar(7,12));
        System.out.println(kthGrammarOld(7,12));
    }

    public static int kthGrammar(int n, int k) { //779
        System.out.println(n + "  " + k);

        if (n == 1) return 0;
        if (k==3) return 0;
        if (k <= 2) {
            //System.out.println(n + "  " + k);
            if (k==1) return 0;
            else return 1;
        }
        return kthGrammar(n-1,(k+1)/2);

    }
    public static int kthGrammarOld(int n, int k) { //779
        StringBuilder builderOld = new StringBuilder().append('0');
        StringBuilder builderNew = new StringBuilder();
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < builderOld.length(); j++) {
                builderNew.append(builderOld.charAt(j));
                if (builderOld.charAt(j) == '0'){
                    builderNew.append('1');
                }
                else builderNew.append('0');
            }
            //System.out.println(builderNew);
            builderOld.setLength(0);
            builderOld.append(builderNew);
            builderNew.setLength(0);
        }
        System.out.println(builderOld);
        //System.out.println((k+n) % 2);
        if (builderOld.charAt(k-1) == '0'){
            return 0;
        }
        else return 1;
    }
}
