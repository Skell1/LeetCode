package org.example;

public class LeetCode_2000_2100 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_2000_2100().timeRequiredToBuy(new int[]{3,1,-2,-5,2,-4}, 2));
    }

    public int timeRequiredToBuy(int[] tickets, int k) { //2073
        int result = 0;
        int c = tickets[k];

        for (int i = 0; i < tickets.length; i++) {
            if (i>k) {
                if (tickets[i]>=c) {
                    result+= c-1;
                }
                else result+= tickets[i];
            }
            else {
                if (tickets[i]>c) {
                    result+= c;
                }
                else result+= tickets[i];
            }
        }
        return result;
    }

}
