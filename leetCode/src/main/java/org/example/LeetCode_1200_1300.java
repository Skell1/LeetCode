package org.example;

import java.util.*;
import org.example.util.ListNode;

public class LeetCode_1200_1300 {
    public static void main(String[] args) {
        ListNode a = new ListNode(1,null);
        ListNode b = new ListNode(0,a);
        ListNode c = new ListNode(1,b);
        System.out.println(getDecimalValue(c));
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

    public static int getDecimalValue(ListNode head) { //1290
        int res = 0;
        while (head != null) {
            res = res * 2 + head.getVal();
            head = head.getNext();
        }
        return res;
    }
}
