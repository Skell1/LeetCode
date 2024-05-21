package org.example.util;



import lombok.Data;

import java.util.*;

@Data
public class TreeNode {
        public int val;
    public TreeNode left;
    public TreeNode right;
        TreeNode() {}
        public TreeNode(int val) { this.val = val; }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    public static TreeNode getRoot(Integer[] nodes) {
        int n = nodes.length;

        if (n == 0) return null;

        ArrayList<TreeNode> parentStack = new ArrayList<>();
        TreeNode root = new TreeNode(nodes[0]);
        TreeNode curParent = root;
        for (int i = 1; i < n; i++) {
            if (i % 2 == 1) {
                if (Objects.nonNull(nodes[i])) {
                    curParent.left = new TreeNode(nodes[i]);
                    parentStack.add(curParent.left);
                }
            } else {
                if (Objects.nonNull(nodes[i])) {
                    curParent.right = new TreeNode(nodes[i]);
                    parentStack.add(curParent.right);
                }
            }
            curParent = parentStack.get(0);
            parentStack.remove(0);
        }
        return root;

    }


    public static   List<List<Integer>> allNextByLevel(TreeNode root, Integer curr, List<List<Integer>> list){ //103
        if (root == null) {
            return list;
        }
        if (list.size()<= curr){
            list.add(curr,new ArrayList<>());
        }
        if (curr % 2 == 0) {
            list.get(curr).add(root.val);
        }
        else list.get(curr).add(0,root.val);
        allNextByLevel(root.left,curr+1,list);
        allNextByLevel(root.right,curr+1,list);
        System.gc();
        return list;
    }

    public static   List<Integer> allLast(TreeNode root, List<Integer> list){ //103
        if (root == null) {
            return list;
        }
        if (Objects.isNull(root.left) && Objects.isNull(root.right)) list.add(root.val);
        allLast(root.left, list);
        allLast(root.right, list);
        return list;
    }

}
