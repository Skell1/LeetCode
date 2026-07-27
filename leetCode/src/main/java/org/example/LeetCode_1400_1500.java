package org.example;

import org.example.util.TreeNode;

import java.util.Arrays;

public class LeetCode_1400_1500 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_1400_1500().maxProduct(new int[]{ 1,1,1,1}));
    }

    public int numSteps(String s) { //1404
        int res = 0;
        boolean hasNext = false;
        for (int i = s.length()-1; i > 0; i--) {
             res++;
            if (s.charAt(i) == '0') {
                if (hasNext) {
                    res++;
                }
            } else {
                if (!hasNext) {
                    res++;
                    hasNext = true;
                }
            }
        }
        if (hasNext) {
            res+=1;
        }
        return res;
    }

    public static int maxScore(String s) { //1422
        int length = s.length();
        int result = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '1') result++;
        }
        if (result == length) return result-1;
        int current = result;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '0'){
                current++;
                if (i == length-1) continue;
                if (current > result){
                    result = current;
                }
            }
            else {
                if (i == 0) result--;
                current--;
            }
        }
        return result;

    }

    public boolean kLengthApart(int[] nums, int k) { //1437
        int current = k;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (current < k) return false;
                current = 0;
            } else {
                current++;
            }
        }
        return true;
    }

    public int pseudoPalindromicPaths (TreeNode root) { //1457
        return pseudoPalindromicPathsUtil(root, new int[9]);
    }

    public int pseudoPalindromicPathsUtil (TreeNode root, int[] array) {
        if (root!=null) {
            array[root.val-1]++;
            if (root.left == null && root.right == null) {
                int k = 0;
                for (int i = 0; i < array.length; i++) {
                    if (array[i] % 2 != 0) {
                        k++;
                        if (k > 1) {
                            return 0;
                        }
                    }
                }
                return 1;
            }
        }
        return (root.right != null ? pseudoPalindromicPathsUtil(root.right , Arrays.copyOf(array, array.length)) : 0) + (root.left != null ? pseudoPalindromicPathsUtil(root.left , Arrays.copyOf(array, array.length)) : 0);
    }

    public int maxProduct(int[] nums) { //1464
        int maxPositive = 0;
        int maxPositive2 = 0;
        int maxNegative = 0;
        int maxNegative2 = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                if (maxNegative2 > nums[i] ) {
                    if (maxNegative > nums[i] ) {
                        maxNegative2 = maxNegative;
                        maxNegative = nums[i];
                    } else {
                        maxNegative2 = nums[i];
                    }
                }
            } else {
                if (maxPositive2 < nums[i] ) {
                    if (maxPositive < nums[i] ) {
                        maxPositive2 = maxPositive;
                        maxPositive = nums[i];
                    } else {
                        maxPositive2 = nums[i];
                    }
                }
            }
        }

        return Math.max((maxPositive2 -1) * (maxPositive -1), (maxNegative2 -1) * (maxNegative -1));

    }

}
