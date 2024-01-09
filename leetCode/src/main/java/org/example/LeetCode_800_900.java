package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.example.util.TreeNode;

public class LeetCode_800_900 {


    public static void main(String[] args) {
        A.TreeNode a7 = new A.TreeNode(7);
        A.TreeNode a15 = new A.TreeNode(15);
        A.TreeNode a20 = new A.TreeNode(20,a15,a7);
        A.TreeNode a9 = new A.TreeNode(9);
        A.TreeNode a3 = new A.TreeNode(3,a9,a20);
        //String s = "ab#c";
        String s = "ab##";
        //String t = "ad#c";
        String t = "c#d#";
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[][] mat = new int[][]{{1,2,3},{4,5,6}};

        //System.out.println(leafSimilar());
    }

    public static boolean leafSimilar(TreeNode root1, TreeNode root2) { //872
        List<Integer>  a = new ArrayList<>();
        List<Integer>  b = new ArrayList<>();

        List anA = TreeNode.allLast(root1, a);
        List anB = TreeNode.allLast(root2, b);
        return anB.equals(anA);
    }

    public static boolean backspaceCompare(String s, String t) {// 844
        List<Character> a = s.chars().mapToObj(e->(char)e).collect(Collectors.toList());
        List<Character> b = t.chars().mapToObj(e->(char)e).collect(Collectors.toList());

        for (int i = 0; i < a.size(); i++) {
            if (a.get(i).equals('#')){
                a.remove(i);
                if (i!=0) {
                    a.remove(i-1);
                    i--;
                }
                i--;
            }
        }
        for (int i = 0; i < b.size(); i++) {
            if (b.get(i).equals('#')){
                b.remove(i);
                if (i!=0){
                    b.remove(i-1);
                    i--;
                }
                i--;
            }
        }

        return a.equals(b);
    }

    public static int[][] transpose(int[][] matrix) { //867
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] ans = new int[c][r];
        for (int i = 0; i < c; i++)
        {
            for (int j = 0; j < r; j++)
            {
                ans[i][j] = matrix[j][i];
            }
        }
        System.gc();
        return ans;
    }
}
