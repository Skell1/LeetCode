package org.example;

import org.example.util.TreeNode;

import java.util.Comparator;
import java.util.List;

public class LeetCode_600_700 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_600_700().maximumSwap(2736));
    }

    public TreeNode addOneRow(TreeNode root, int val, int depth) { //623
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }
        if (root == null) return root;
        if (depth ==2) {
            TreeNode right = root.right;
            TreeNode left = root.left;
            root.right = new TreeNode(val, null, right);
            root.left = new TreeNode(val, left, null);
            return root;
        }

        addOneRow(root.left,val, depth-1);

        addOneRow(root.right,val, depth-1);

        return root;

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

    public int maximumSwap(int num) { //670
        StringBuilder s = new StringBuilder(String.valueOf(num));
        char ch = '9';
        int i,j;
        for (i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '9') continue;
            while (s.charAt(i) < ch) {
                for (j = s.length()-1 ; j > i; j--) {
                    if (s.charAt(j) == ch) {
                        char temp = s.charAt(j);
                        s.setCharAt(j, s.charAt(i));
                        s.setCharAt(i, temp);
                        return Integer.parseInt(s.toString());
                    }
                }
                ch--;
            }
        }
        return Integer.parseInt(s.toString());

    }

}
