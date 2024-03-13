package org.example;

public class LeetCode_2400_2500 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_2400_2500().pivotInteger(8));
    }

    public int pivotInteger(int n) {  //2485
        int c = 1;
        while (c < n) {
            if (summ(1,c) == summ(c,n)) return c;
            if (summ(1,c) > summ(c,n)) return -1;
            c++;
        }
        return -1;
    }

    public int summ (int a, int b) {
        return (a+b)*(b-a+1)/2;
    }

}
