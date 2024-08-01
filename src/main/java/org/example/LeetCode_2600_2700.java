package org.example;

public class LeetCode_2600_2700 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_2600_2700().countSeniors(new String[]{"7868190130M0022","7868190130M7522","5303914400F9211","9273338290F4010"}));
    }
    public int countSeniors(String[] details) { //2678
        int count = 0;
        for (String detail : details) {
            if ((detail.charAt(11) - 48) * 10 + (detail.charAt(12) - 48) > 60) {
                count++;
            }
        }
        return count;
    }
}
