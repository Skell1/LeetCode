package org.example;

public class LeetCode_3000_3100 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_3000_3100().triangleType(new int[]{8,4,2}));
    }

    public int areaOfMaxDiagonal(int[][] dimensions) { //3000
        double res = 0;
        int result = 0;
        for (int[] dimension : dimensions) {
            double def = Math.sqrt(dimension[0] * dimension[0] + dimension[1] * dimension[1]);
            if (def > res) {
                res = def;
                result = dimension[0]*dimension[1];
            }
            if (def == res) {
                result = Math.max(dimension[0] * dimension[1], result);
            }
        }
        return result;
    }

    public String triangleType(int[] nums) { //3024
        if (nums[0] + nums[1] <= nums[2] ||
                nums[0] + nums[2] <= nums[1] ||
                nums[1] + nums[2] <= nums[0]) return "none";
        if (nums[1] == nums[2] && nums[1] == nums[0]) return "equilateral";
        if (nums[0] == nums[1] || nums[1] == nums[2] || nums[0] == nums[2]) return "isosceles";
        return "scalene";
    }
}
