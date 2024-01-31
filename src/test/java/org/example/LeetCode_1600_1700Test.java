package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeetCode_1600_1700Test {

    @Test
    void closeStrings1() {
        Boolean answer = (new  LeetCode_1600_1700()).closeStrings("abc", "bca");
        assertEquals(answer, true);
    }

    @Test
    void closeStrings2() {
        Boolean answer = (new  LeetCode_1600_1700()).closeStrings("cabbba", "abbccc");
        assertEquals(answer, true);
    }

    @Test
    void closeStrings3() {
        Boolean answer = (new  LeetCode_1600_1700()).closeStrings("uau", "ssx");
        assertEquals(answer, false);
    }
}