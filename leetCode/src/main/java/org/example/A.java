package org.example;

import java.util.LinkedList;
import java.util.List;

public class A {
    public List<Integer> addToArrayForm_989(int[] num, int k) {
        LinkedList<Integer> arrayList = new LinkedList<>();
        int i = num.length-1;
        boolean key1 = true,key2 = true;
        int a=0,b=0,s;
        int next = 0;
        while (true){
            if (i>=0){
                a = num[i];
                i--;
            }
            else key1 = false;
            if (k>0){
                b = k % 10;
                k/=10;
            }
            else key2 = false;
            if (!key1 && !key2 && next == 0) break;
            s = a+b+next;
            next = 0;
            if (s>=10){
                next=1;
                s = s- 10;
            }
            arrayList.addFirst(s);
            a=0;b=0;
        }
        return arrayList;
    }

    public static String addBinary_67(String a, String b) {
        char[] max;
        char[] min;
        if (a.length()>=b.length()) {
            max = a.toCharArray();
            min = b.toCharArray();
        }
        else {
            max = b.toCharArray();
            min = a.toCharArray();
        }
        int key = 0;
        StringBuilder answ = new StringBuilder();
        for (int i = min.length-1; i >= 0; i--) {
            int k = min[i]+max[i+max.length-min.length] + key;
            if (k==98){   //(2)  (98)   //1 = 49
                answ.insert(0, 0);
                key = 1;
            }
            else if (k==99){ //(3)
                answ.insert(0, 1);
                key = 1;
            }
            else if (k==97){ //97 (1)
                answ.insert(0, 1);
                key = 0;
            }
            else if (k==96){ //96 (0)
                answ.insert(0, 0);
                key = 0;
            }
        }

        for (int i = max.length-min.length-1; i >= 0; i--) {
            int k = max[i] + key;
            if (k==50){   //2(50)   //1 = 49
                answ.insert(0, 0);
                key = 1;
            }
            else if (k==51){ //3
                answ.insert(0, 1);
                key = 1;
            }
            else if (k==49){ //97 (1)
                answ.insert(0, 1);
                key = 0;
            }
            else if (k==48){ //97 (1)
                answ.insert(0, 0);
                key = 0;
            }
        }
        if (key == 1) answ.insert(0, 1);
        return answ.toString();
}
}

