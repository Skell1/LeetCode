package org.example;

import java.util.*;

public class LeetCode_400_500 {
    public static void main(String[] args) {
        TreeNode node9 = new TreeNode(9, null, null);
        TreeNode node15 = new TreeNode(15, null, null);
        TreeNode node7 = new TreeNode(7, null, null);
        TreeNode node20 = new TreeNode(20, node15, node7);

        TreeNode root = new TreeNode(3, node9, node20);


        System.out.println(new LeetCode_400_500().sumOfLeftLeaves(root));
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

    public String removeKdigits(String num, int k) { //402
        StringBuilder sb = new StringBuilder(num);
        for (int i = 0; i < sb.length()-1 && k>0; i++) {
            if (sb.charAt(i)>sb.charAt(i+1)) {
                sb.deleteCharAt(i);
                i-=2;
                if (i<-1) i = -1;
                k--;
            }
        }
        System.out.println(sb);
        while (k>0 && sb.length()>0) {
            sb.deleteCharAt(sb.length()-1);
            k--;
        }
        while (sb.length()>0 && sb.charAt(0) == '0' ){
            sb.deleteCharAt(0);
        }
        if (sb.length()==0) return "0";
        return sb.toString();
    }

    public int sumOfLeftLeaves(TreeNode root) { //404
        if (root == null) return 0;
        int a;
        if (root.left != null && root.left.left == null && root.left.right == null) a = root.left.val;
        else
        a = sumOfLeftLeaves(root.left);
        int b = sumOfLeftLeaves(root.right);
        return a+b;
    }

    public int longestPalindrome(String s) { //409
        if (s.length() < 2) return s.length();
            HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int max = 0;
        Boolean dop = false;
        for (Integer entry : map.values()) {
            if (entry >= 2) {
                max += entry - entry%2;
            }
            if (!dop) {
                if (entry % 2 != 0) {
                    dop = true;
                }
            }
        }
        return dop ? max+1 : max;
    }

    public List<Integer> findDuplicates(int[] nums) { //442
        int[] temp = new int[nums.length+1];
        List<Integer> list = new ArrayList<>();
        //Arrays.fill(temp,0);
        for (int num : nums) {
            temp[num]++;
            if (temp[num] == 2) list.add(num);
        }
        return list;
    }

    public static String frequencySort(String s) { //451
        Map<Character, StringBuilder> map = new HashMap<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            map.computeIfAbsent(ch, k -> new StringBuilder()).append(ch);
        }
        StringBuilder builder = new StringBuilder();
        map.values().stream().sorted((s1,s2) -> s2.length() - s1.length()).forEach(builder::append);
        return builder.toString();
    }
}
