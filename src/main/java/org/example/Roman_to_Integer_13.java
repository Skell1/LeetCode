package org.example;

public class Roman_to_Integer_13 {
    public static int romanToInt(String s) {
        int value = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case ('M') -> value += 1000;
                case ('D') -> value += 500;
                case ('C') -> {
                    if (i < chars.length - 1) {
                        if (chars[i + 1] == 'D') {
                            i++;
                            value += 400;
                            break;
                        } else if (chars[i + 1] == 'M') {
                            i++;
                            value += 900;
                            break;
                        }
                    }
                    value += 100;
                }
                case ('L') -> value += 50;
                case ('X') -> {
                    if (i < chars.length - 1) {
                        if (chars[i + 1] == 'L') {
                            i++;
                            value += 40;
                            break;
                        } else if (chars[i + 1] == 'C') {
                            i++;
                            value += 90;
                            break;
                        }
                    }
                    value += 10;
                }
                case ('V') -> value += 5;
                case ('I') -> {
                    if (i < chars.length - 1) {
                        if (chars[i + 1] == 'V') {
                            i++;
                            value += 4;
                            break;
                        } else if (chars[i + 1] == 'X') {
                            i++;
                            value += 9;
                            break;
                        }
                    }
                    value += 1;
                }
            }
        }
        return value;
    }
}
