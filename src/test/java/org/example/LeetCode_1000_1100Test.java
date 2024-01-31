package org.example;

import org.example.util.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeetCode_1000_1100Test {

    @Test
    void maxAncestorDiff() {
        TreeNode a6 = new TreeNode(6);
        TreeNode a0 = new TreeNode(0);
        TreeNode a7 = new TreeNode(7);

        TreeNode a1 = new TreeNode(1, null, a6);
        TreeNode a5 = new TreeNode(5, null, a7);
        TreeNode a3 = new TreeNode(3, a0, a5);
        TreeNode a4 = new TreeNode(4, a1, null);

        TreeNode a2 = new TreeNode(2, a4, a3);

        Integer answ = LeetCode_1000_1100.maxAncestorDiff(a2);
        assertEquals(answ, 5);
    }
}