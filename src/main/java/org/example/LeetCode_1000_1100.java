package org.example;

import org.example.util.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_1000_1100 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_1000_1100().commonChars(new String[]{"bella","label","roller"}));
    }

    public List<String> commonChars(String[] words) { //1002
        int[] t = new int[26];
        for (char c : words[0].toCharArray()) {
            t[c - 'a']++;
        }

        int[] q;
        for (int i = 1; i < words.length; i++) {
            q = new int[26];
            for (char c : words[i].toCharArray()) {
                q[c - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                if (t[j] > q[j]) {
                    t[j] = q[j];
                }
            }
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (t[i] > 0) {
                for (int j = 0; j < t[i]; j++) {
                    res.add(String.valueOf((char) (i+'a')));
                }
            }
        }
        return res;
    }

    public int heightChecker(int[] heights) { //1051
        int[] arr = Arrays.copyOf(heights, heights.length);
        Arrays.sort(arr);
        int count = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] != arr[i]) count++;
        }
        return count;
    }
    public static int maxAncestorDiff(TreeNode root) {
        return nextTreeNode(root, root.val, root.val);
    }

    public static Integer nextTreeNode(TreeNode treeNode, Integer lastMax, Integer lastMin) {
        if (treeNode == null) return lastMax-lastMin;

        if (treeNode.val>lastMax) lastMax= treeNode.val;
        if (treeNode.val<lastMin) lastMin = treeNode.val;

        int max1 = nextTreeNode(treeNode.left,lastMax, lastMin);
        int max2 = nextTreeNode(treeNode.right,lastMax, lastMin);
        return max1>max2?max1:max2;
    }
}
