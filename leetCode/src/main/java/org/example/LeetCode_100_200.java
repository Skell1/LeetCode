package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode_100_200 {
    public static void main(String[] args) {
        int[] a = new  int[] {1,2,3,4,5,6,7};
        int[] b = new  int[] {-1,-100,3,99};
        rotate(a,3);

        rotate(b,2);
        //new LeetCode_100_200().compareVersion("1.2", "1.10");
        System.out.println(new LeetCode_100_200().generate(5));

    }

    public List<List<Integer>> generate(int numRows) { //118
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        List<Integer> create;

        temp.add(1);
        res.add(temp);
        for (int i = 2; i <= numRows; i++) {
            temp = res.get(i-2);
            create = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i) {
                    create.add(1);
                } else {
                    create.add(temp.get(j - 2) + temp.get(j-1));
                }
            }
            res.add(create);
        }
        return res;
    }

    public int minimumTotal(List<List<Integer>> triangle) { //120

        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0) {
                    triangle.get(i).set(j, triangle.get(i).get(j)+triangle.get(i-1).get(j));
                } else if (j == triangle.get(i).size() - 1) {
                    triangle.get(i).set(j, triangle.get(i).get(j)+triangle.get(i-1).get(j-1));
                } else {
                    triangle.get(i).set(j, triangle.get(i).get(j)+Math.min(triangle.get(i-1).get(j-1),triangle.get(i-1).get(j)));
                }
                }
            }
        return triangle.get(triangle.size()-1).stream().min(Integer::compareTo).get();
    }

    public int evalRPN(String[] tokens) { //150
        Stack<Integer> stack = new Stack<>();
        String temp;
        Integer num;
        for (int i = 0; i < tokens.length; i++) {
            temp = tokens[i];
            if (temp.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            }
            else if (temp.equals("-")) {
                num = stack.pop();
                stack.push(stack.pop() - num);
            }
            else if (temp.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            }
            else if (temp.equals("/")) {
                num = stack.pop();
                stack.push(stack.pop() / num);
            }
            else {
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.peek();
    }

    public int compareVersion(String version1, String version2) { //165
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int length = Math.max(v1.length, v2.length);

        for (int i = 0; i < length; i++) {
            if (v1.length>i && v2.length>i) {
                if (Integer.parseInt(v1[i])>Integer.parseInt(v2[i])) {
                    return 1;
                } else if (Integer.parseInt(v1[i])<Integer.parseInt(v2[i])) {
                    return -1;
                }
            } else {
                if (v1.length>i) {
                    if (Integer.parseInt(v1[i])>0) {
                        return 1;
                    }
                } else {
                    if (Integer.parseInt(v2[i])>0) {
                        return -1;
                    }
                }
            }
        }
        return 0;
    }

    public static void rotate(int[] nums, int k) { // 189
        final int size = nums.length;
        if (k > size) k = k % size;
        int[] a = new int[size-k];
        int[] b = new int[k];
        System.arraycopy(nums, 0, a, 0, size-k);
        System.arraycopy(nums, size-k, b, 0, k);
        System.arraycopy(b, 0, nums, 0,k);
        System.arraycopy(a, 0, nums, k, size-k);
    }

    public int rob(int[] nums) { //198
        int n = nums.length;
        int pre = 0, cur = 0;
        for (int i = 0; i < n; i++) {
            int temp = Math.max(pre + nums[i], cur);
            pre = cur;
            cur = temp;
        }
        return cur;
    }

}
