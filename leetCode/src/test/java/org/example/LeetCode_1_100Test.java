package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeetCode_1_100Test {

    @Test
    void climbStairs() {
        int result = new LeetCode_1_100().climbStairs(45);
        assertEquals(result, 1836311903);
    }
}