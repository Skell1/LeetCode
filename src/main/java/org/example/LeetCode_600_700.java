package org.example;

import java.util.Comparator;
import java.util.List;

public class LeetCode_600_700 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_600_700().replaceWords(List.of("cat","bat","rat"), "the cattle was rattled by the battery"));
    }

    public String replaceWords(List<String> dictionary, String sentence) { //648
        String[] words = sentence.split(" ");
        dictionary = dictionary.stream().sorted(Comparator.comparingInt(String::length)).toList();

        for (int i = 0; i < words.length; i++) {
            for (String d : dictionary) {
                if (words[i].startsWith(d)) {
                    words[i] = d;
                    break;
                }
            }
        }
        return String.join(" ", words);
    }

    public static int[][] imageSmoother(int[][] img) { //661
        int x = img.length;
        int y = img[0].length;
        int[][] result = new int[x][y];
        int a;
        int count;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                a = img[i][j];
                count = 1;
                if (i>0) {
                    a+= img[i-1][j];
                    count++;
                    if (j>0) {
                        a += img[i - 1][j - 1];
                        count++;
                    }
                    if (j<y-1) {
                        a += img[i - 1][j + 1];
                        count++;
                    }
                }
                if (i<x-1){
                    a+=img[i+1][j];
                    count++;
                    if (j>0) {
                        a += img[i + 1][j - 1];
                        count++;
                    }

                    if (j<y-1) {
                        a += img[i + 1][j + 1];
                        count++;
                    }

                }

                if (j>0) {
                    a+= img[i][j-1];
                    count++;
                }
                if (j<y-1){
                    a+=img[i][j+1];
                    count++;
                }
                result[i][j]= a/count;

            }

        }
        System.gc();
        return result;
    }

}
