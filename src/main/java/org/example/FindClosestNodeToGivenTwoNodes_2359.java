package org.example;

import java.util.HashSet;

public class FindClosestNodeToGivenTwoNodes_2359 {
    public static int closestMeetingNode(int[] edges, int node1, int node2) {
        int length = edges.length+1;
        if (node1 == node2) return node1;
        HashSet<Integer> map1 = new HashSet<>();
        map1.add(node1);
        HashSet<Integer> map2 = new HashSet<>();
        map2.add(node2);
        int next1 = edges[node1];
        int next2 = edges[node2];
        int answer = length;
        while (true){
            if ((next1 == -1 && next2 == -1) || answer < length){
                break;
            }
            if (next1 != -1){
                if (map2.contains(next1)) {
                    answer = next1;
                }
                if (!map1.contains(next1)) {
                    map1.add(next1);
                    next1 = edges[next1];
                }
                else next1 =- 1;
            }

            if (next2 != -1){
                if (map1.contains(next2)) {
                    if (answer > next2)
                        answer = next2;
                    break;
                }
                if (!map2.contains(next2)) {
                    map2.add(next2);
                    next2 = edges[next2];
                }
                else next2=-1;
            }
        }
        if (answer == length) return -1;
        return answer;
    }
}
