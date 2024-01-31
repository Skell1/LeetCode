package org.example;

import org.example.util.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeetCode_800_900Test {

    @Test
    void leafSimilar1() {
        TreeNode a6 = new TreeNode(6);
        TreeNode a7 = new TreeNode(7);
        TreeNode a4 = new TreeNode(4);
        TreeNode a9 = new TreeNode(9);
        TreeNode a8 = new TreeNode(8);

        TreeNode a2 = new TreeNode(2, a7, a4);
        TreeNode a5 = new TreeNode(5, a6, a2);
        TreeNode a1 = new TreeNode(1, a9, a8);

        TreeNode a3 = new TreeNode(3, a5, a1);

        TreeNode b6 = new TreeNode(6);
        TreeNode b7 = new TreeNode(7);
        TreeNode b4 = new TreeNode(4);
        TreeNode b9 = new TreeNode(9);
        TreeNode b8 = new TreeNode(8);

        TreeNode b2 = new TreeNode(2, a9, a8);
        TreeNode b5 = new TreeNode(5, a6, a7);
        TreeNode b1 = new TreeNode(1, a4, a2);

        TreeNode b3 = new TreeNode(3, a5, a1);




        boolean answ = LeetCode_800_900.leafSimilar(a3,b3);
        assertTrue(answ);
    }

    @Test
    void leafSimilar2() {

        TreeNode a3 = new TreeNode(3);
        TreeNode a2 = new TreeNode(2);
        TreeNode a1 = new TreeNode(1, a3, a2);
        TreeNode b1 = new TreeNode(1, a2, a3);


        boolean answ = LeetCode_800_900.leafSimilar(a1,b1);
        assertFalse(answ);
    }
}