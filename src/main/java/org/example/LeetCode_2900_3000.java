package org.example;

import java.util.*;

public class LeetCode_2900_3000 {
    public static void main(String[] args) {
        System.out.println(findAllPeople(5, new int[][]{{3,4,2},{1,2,1},{2,3,1}} , 1));
    }
    public static List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) { //2092
        Set<Integer> whoKnow = new HashSet<>();
        whoKnow.add(firstPerson);
        whoKnow.add(0);
        int[] def;
        Map<Integer,List<int[]>> map = new TreeMap<>();
        for (int i = 0; i < meetings.length; i++) {
            def = meetings[i];
            map.computeIfAbsent(def[2],k -> new ArrayList<>()).add(new int[]{def[0],def[1]});
        }
        List<int[]> list;
        boolean ifChange = false;
        for (Integer key : map.keySet().stream().sorted().toList()){
            list = map.get(key);
            for (int i = 0; i < list.size(); i++) {
                def = list.get(i);
                if (whoKnow.contains(def[0])){
                    whoKnow.add(def[1]);
                    list.remove(i);
                  //  i=-1;
                    ifChange = true;
                }
                else if (whoKnow.contains(def[1])){
                    whoKnow.add(def[0]);
                    list.remove(i);
                   // i=-1;
                    ifChange = true;
                }
                if (i==list.size()-1 && ifChange){
                    i=-1;
                }
            }
        }
        return whoKnow.stream().toList();
    }

    public static int[][] divideArray(int[] nums, int k) { //2966
        nums = Arrays.stream(nums).sorted().toArray();
        int[][] result = new int[nums.length/3][3];
        int i,j;
        for ( i = 0, j =0; i < nums.length; i+=3, j++) {
            if (nums[i+2] - nums[i] <=k) {
                result[j][0] = nums[i];
                result[j][1] = nums[i+1];
                result[j][2] = nums[i+2];
            }
            else return new int[0][0];
        }
        for (int l = 0; l < nums.length % 3; l++) {
            result[j][i] = nums[nums.length-3+l];
        }
        return result;
    }
}
