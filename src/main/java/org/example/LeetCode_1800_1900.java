package org.example;

import java.util.ArrayList;

public class LeetCode_1800_1900 {
    public static void main(String[] args) {

        System.out.println(new LeetCode_1800_1900().findTheWinner(5,2));
    }

    public int findTheWinner(int n, int k) { //1823
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int current = -1;
        while (list.size() > 1) {
            current += k;
            if (current >= list.size()) {
                current = current%list.size();
            }
            list.remove(current);
        }
        return list.get(0);

    }


}
