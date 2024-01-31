package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeetCode_1300_1400Test {

    @Test
    void minSteps1() {
        int result = LeetCode_1300_1400.minSteps("bab","aba");
        assertEquals(1,result);
    }
}