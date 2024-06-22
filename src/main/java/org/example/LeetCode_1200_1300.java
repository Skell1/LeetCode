package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class LeetCode_1200_1300 {
    public static void main(String[] args) {
        int[] a = new int[]{1,1,2,1,1}; //3  2
        int[] b = new int[]{2,2,2,1,2,2,1,2,2,2}; //2  16
        int[] c = new int[]{2044,96397,50143}; //1


        //   System.out.println(sequentialDigits(8511,23553));
        //System.out.println(new LeetCode_1200_1300().numberOfSubarrays(a,3));
        System.out.println(new LeetCode_1200_1300().numberOfSubarrays(b,2));

        //System.out.println(new LeetCode_1200_1300().numberOfSubarrays(c,1));

        //System.out.println();
    }

    public static List<Integer> sequentialDigits(int low, int high) { //1291
        List<Integer> result = new ArrayList<>();
        int count = String.valueOf(low).length(),
        stepen = (int) Math.pow(10,String.valueOf(low).length()-1), current = 0, first = low / stepen;
        int defStepen = stepen;

        for (int i = low; i < high; i = first*stepen) {
            current = 0;
            for (int j = first; j < first + count; j++ , defStepen = defStepen / 10) {
                current += j*defStepen;
            }
            if (first + count <= 10) {
                result.add(current);
            }
            first++;
            if (first + count > 10){
                count++;
                first = 1;
                stepen *= 10;
            }
            defStepen = stepen;
        }
        if (!result.isEmpty() && result.get(0) < low) result.remove(0);
        if (!result.isEmpty() && result.get(result.size()-1) > high)
            result.remove(result.size()-1);

        return result;
    }

    public boolean uniqueOccurrences(int[] arr) { //1207
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) map.put(arr[i], map.get(arr[i]) + 1);
            else map.put(arr[i], 1);
        }
        Collection<Integer> list = map.values();
        List<Integer> list1 = map.values().stream().distinct().toList();
        return map.values().size() == map.values().stream().distinct().toList().size();
    }

    public int numberOfSubarrays(int[] nums, int k) { //1248
        int curr = 0;
        int res = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                curr++;
            } else {
                list.add(curr);
                curr = 0;
            }
        }
        list.add(curr);
        for (int i = 0; i+k < list.size(); i++) {
            res+= (list.get(i)+1) * (list.get(i + k)+1);
        }
        //res+= list.size() % k;
        return res;
    }

    public static int findSpecialInteger(int[] arr) { //1287
        int aa = arr.length/4;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == arr[i+aa]){
                System.gc();
                return arr[i];
            }
        }
        return 0;
    }
}
