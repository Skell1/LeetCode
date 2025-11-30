package org.example;

import java.util.*;

public class LeetCode_300_400 {
    public static void main(String[] args) {
        System.out.println(isPowerOfFour(-16));
    }

    public boolean isPowerOfThree(int n) { //326
        if (n <= 0) return false;
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
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
