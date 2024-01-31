package org.example;

public class A1523 {
    public int countOdds(int low, int high) {
        if (low % 2 == 0 && high % 2 == 0){
            return (high-low)/2;
        }
        else if (low % 2 != 0 && high % 2 != 0){
            return (high-low)/2+1;
        }
        else
            return (high-low)/2;
    }
}
