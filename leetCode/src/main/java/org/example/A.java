package org.example;

import java.util.*;

public class A {
    public static void main(String[] args) {
        TreeNode a7 = new TreeNode(7);
        TreeNode a15 = new TreeNode(15);
        TreeNode a20 = new TreeNode(20,a15,a7);
        TreeNode a9 = new TreeNode(9);
        TreeNode a3 = new TreeNode(3,a9,a20);
        int [] nums = {1,4,6,7,8,9};

        int[] nums1 ={1,3,4,6,7,10};

        System.out.println(bulbSwitch(2));
        //System.out.println(zigzagLevelOrder(a3));
    }
    public static int bulbSwitch(int n) {  //319
        return (int)(Math.sqrt(n));
    }
    public static int searchInsert(int[] nums, int target) {  //35
        int k = nums.length/2;
        int up = nums.length;
        int down = 0;
        while (true){
            if (nums[k]==target){
                return k;
            }
            if (nums[k]> target){
                if (k==0) return k;
                if (nums[k-1]<target) return k;
                up = k;
                k = k/2;

            }
            else {
                if (k==nums.length -1) {
                    return k + 1;
                }
                else if  (nums[k+1]>target) return k+1;
                down = k;
                k = (up + down)/2;
            }
        }
    }


    public static   List<List<Integer>> zigzagLevelOrder(TreeNode root) {  //103
        List<List<Integer>>  a103 = new ArrayList<>();
        return next103(root,0,a103);

    }
    public static   List<List<Integer>> next103(TreeNode root, Integer curr,List<List<Integer>> a103){
        if (root == null) {
            return a103;
        }
        if (a103.size()<= curr){
            a103.add(curr,new ArrayList<>());
        }
        if (curr % 2 == 0) {
            a103.get(curr).add(root.val);
        }
        else a103.get(curr).add(0,root.val);
        next103(root.left,curr+1,a103);
        next103(root.right,curr+1,a103);
        return a103;
    }



    public static int minDiffInBST_783(TreeNode root) {
        ArrayList<Integer> list= new ArrayList<>();
        list = minDiffInBST(root,list);
        Collections.sort(list);
        int min = Math.abs(list.get(0)- list.get(1));
        for (int i = 1; i < list.size()-1; i++) {
            int a = Math.abs(list.get(i)- list.get(i+1));
            if (a < min){
                min = a;
            }
        }
        return min;
    }
    public static ArrayList<Integer> minDiffInBST(TreeNode root,ArrayList list) {
        if (root == null) {
            return list;
        }
        list.add(root.val);
        minDiffInBST(root.left,list);
        minDiffInBST(root.right,list);
        return list;
    }

    public static int maxDepth_104(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth_104(root.left);
        int right = maxDepth_104(root.right);

        return Math.max(left, right) + 1;
    }
    public int nextTreeNodes(TreeNode root) {
        int k = 0;
        ArrayList<TreeNode> treeNodes = new ArrayList<>();
        treeNodes.add(root);
        return     0;
    }

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public List<Integer> addToArrayForm_989(int[] num, int k) {
        LinkedList<Integer> arrayList = new LinkedList<>();
        int i = num.length-1;
        boolean key1 = true,key2 = true;
        int a=0,b=0,s;
        int next = 0;
        while (true){
            if (i>=0){
                a = num[i];
                i--;
            }
            else key1 = false;
            if (k>0){
                b = k % 10;
                k/=10;
            }
            else key2 = false;
            if (!key1 && !key2 && next == 0) break;
            s = a+b+next;
            next = 0;
            if (s>=10){
                next=1;
                s = s- 10;
            }
            arrayList.addFirst(s);
            a=0;b=0;
        }
        return arrayList;
    }

    public static String addBinary_67(String a, String b) {
        char[] max;
        char[] min;
        if (a.length()>=b.length()) {
            max = a.toCharArray();
            min = b.toCharArray();
        }
        else {
            max = b.toCharArray();
            min = a.toCharArray();
        }
        int key = 0;
        StringBuilder answ = new StringBuilder();
        for (int i = min.length-1; i >= 0; i--) {
            int k = min[i]+max[i+max.length-min.length] + key;
            if (k==98){   //(2)  (98)   //1 = 49
                answ.insert(0, 0);
                key = 1;
            }
            else if (k==99){ //(3)
                answ.insert(0, 1);
                key = 1;
            }
            else if (k==97){ //97 (1)
                answ.insert(0, 1);
                key = 0;
            }
            else if (k==96){ //96 (0)
                answ.insert(0, 0);
                key = 0;
            }
        }

        for (int i = max.length-min.length-1; i >= 0; i--) {
            int k = max[i] + key;
            if (k==50){   //2(50)   //1 = 49
                answ.insert(0, 0);
                key = 1;
            }
            else if (k==51){ //3
                answ.insert(0, 1);
                key = 1;
            }
            else if (k==49){ //97 (1)
                answ.insert(0, 1);
                key = 0;
            }
            else if (k==48){ //97 (1)
                answ.insert(0, 0);
                key = 0;
            }
        }
        if (key == 1) answ.insert(0, 1);
        return answ.toString();
}
}

