package org.example;

import lombok.val;
import org.example.util.TreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class LeetCode_1400_1500 {
    public static void main(String[] args) {
        System.out.println(findLeastNumOfUniqueInts(new int[] {4,3,1,1,3,3,2}, 3));
        //1011011  5
        //11100  2
    }

    public static int findLeastNumOfUniqueInts(int[] arr, int k) { //1481
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
            else map.put(arr[i],1);
        }

        List<Map.Entry<Integer,Integer>> a = map.entrySet()
                .stream().sorted((e,e1) -> e.getValue().compareTo(e1.getValue())).toList();
        int result = a.size();
        for (Map.Entry entry : a){
            if (k-(Integer) entry.getValue() >= 0) {
                k -=(Integer) entry.getValue();
                result--;
            }
        }
        return result;
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
}
