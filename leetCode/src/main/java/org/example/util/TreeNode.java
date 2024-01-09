package org.example.util;



import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        public TreeNode(int val) { this.val = val; }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
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
