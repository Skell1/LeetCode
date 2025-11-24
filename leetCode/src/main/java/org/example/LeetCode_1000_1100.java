package org.example;

import org.example.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_1000_1100 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_1000_1100().prefixesDivBy5(new int[]{0,1,1,1,1,1}));
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

    public List<Boolean> prefixesDivBy5(int[] nums) { //1018
        List<Boolean> res = new ArrayList<>();
        int curr = 0;
        for (int i = 0; i < nums.length; i++) {
            curr *= 2;
            curr+= nums[i];
            if (curr%5==0) {
                res.add(true);
            } else res.add(false);
            curr %= 5;
        }
        return res;
    }
}
