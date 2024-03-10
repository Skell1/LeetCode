package org.example;

import java.util.*;

public class LeetCode_300_400 {
    public static void main(String[] args) {

        System.out.println(firstUniqChar("aabb"));
    }

    public int[] intersection(int[] nums1, int[] nums2) { //349
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    set.add(nums1[i]);
                    break;
                }
            }
        }
        return set.stream().mapToInt(v -> v).toArray();

    }
    public static int firstUniqChar(String s) { //387
        int ans = Integer.MAX_VALUE;
        for(char c='a'; c<='z';c++){
            int index = s.indexOf(c);
            if(index!=-1&&index==s.lastIndexOf(c)){
                ans = Math.min(ans,index);
            }
        }

        return ans==Integer.MAX_VALUE?-1:ans;
    }
    public static int firstUniqChar1(String s) {//387 Мой первый
        int[] array = new int[128];
        Arrays.fill(array, -1);
        int index;
        for (int i = 0; i < s.length(); i++) {
            index = s.charAt(i);
            if (array[index] >= 0 || array[index] == -2) {
                array[index] = -2;
            }
            else array[index] = i;
        }
        int result = Integer.MAX_VALUE;
        for (int a : array){
            if (a > -1 && a < result) result = a;
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    class RandomizedSet { //380
        HashMap<Integer, Integer> map;
        List<Integer> list;
        Random random;

        public RandomizedSet() {
            map=new HashMap<>();
            list=new ArrayList<>();
            random=new Random();
        }

        public boolean insert(int val) {

            if(map.containsKey(val)) {
                return false;
            }
            map.put(val, list.size());
            list.add(val);
            return true;
        }

        public boolean remove(int val) {

            if(!map.containsKey(val)) {
                return false;
            }

            int idx=map.get(val);
            int lastIdx=list.size()-1;

            if(idx!=lastIdx) {
                list.set(idx, list.get(lastIdx));
                map.put(list.get(lastIdx), idx);
            }
            map.remove(val);
            list.remove(lastIdx);
            return true;
        }

        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }

    public static boolean isPowerOfFour(int n) {//342
        if (n< 0 ) return false;
       while (n >= 4 || n <= -4) {
            if (n % 4 != 0) return false;
            n /= 4;
        }
        if (n == 1) {
            return true;
        }
        else return false;
    }
}
