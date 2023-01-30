package org.example;

public class A1137 {
    public static int tribonacci(int n) {
        int a = 0;
        int b = 1;
        int c = 1;
        switch (n) {
            case (0) -> {
                return a;
            }
            case (1) -> {
                return b;
            }
            case (2) -> {
                return c;
            }
        }
        while (n>2) {
            int d = a+b+c;
            a = b;
            b = c;
            c = d;
            n--;
        }
            return c;
    }
}
