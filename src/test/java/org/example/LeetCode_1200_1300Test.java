package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeetCode_1200_1300Test {

    @Test
    void uniqueOccurrences1() {
        Boolean anwer = new LeetCode_1200_1300().uniqueOccurrences(new int[]{3,5,-2,-3,-6,-6});
        assertEquals(anwer,false);
    }

    @Test
    void uniqueOccurrences2() {
        Boolean anwer = new LeetCode_1200_1300().uniqueOccurrences(new int[]{1,2,2,1,1,3});
        assertEquals(anwer,true);
    }
}