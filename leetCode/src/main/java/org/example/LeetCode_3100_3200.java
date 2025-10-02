package org.example;

public class LeetCode_3100_3200 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_3100_3200().clearDigits("cb34"));
    }

    public int maxBottlesDrunk(int numBottles, int numExchange) { //3100
        int drinkCount = 0;
        int emptyCount = 0;

        while (true) {
            if (numBottles > 0) {
                emptyCount += numBottles;
                drinkCount += numBottles;
                numBottles = 0;
            } else if (emptyCount >= numExchange) {
                emptyCount -= numExchange;
                numExchange++;
                numBottles++;
            } else {
                break;
            }
        }
        return drinkCount;
    }

    public int longestMonotonicSubarray(int[] nums) { //3105
        int increasing = 1, decreasing = 1;
        int maxincreasing = 1, maxdecreasing = 1;

        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] < nums[i+1]) {
                increasing+=1;
                if (decreasing > maxdecreasing) {
                    maxdecreasing = decreasing;
                }
                decreasing = 1;
            }

            else if (nums[i] > nums[i+1]) {
                decreasing+=1;
                if (increasing > maxincreasing) {
                    maxincreasing = increasing;
                }
                increasing = 1;
            } else {
                if (decreasing > maxdecreasing) {
                    maxdecreasing = decreasing;
                }
                if (increasing > maxincreasing) {
                    maxincreasing = increasing;
                }
                increasing = 1;
                decreasing = 1;

            }
        }

        maxincreasing = Math.max(increasing, maxincreasing);
        maxdecreasing = Math.max(decreasing, maxdecreasing);

        return Math.max(maxincreasing, maxdecreasing);

    }

    public boolean isArraySpecial(int[] nums) { //3151
        for (int i = 0; i < nums.length - 1; i++) {
            if ((nums[i] + nums[i + 1]) % 2 == 0) {
                return false;
            }
        }
        return true;
    }

    public String clearDigits(String s) { //3174
        StringBuilder sb = new StringBuilder(s);
        for (int i = 1; i < sb.length(); i++) {
            if (sb.charAt(i) >= '0' && sb.charAt(i) <= '9') {
                sb.deleteCharAt(i);
                sb.deleteCharAt(i-1);
                i-=2;
            }
        }
        return sb.toString();
    }

}
