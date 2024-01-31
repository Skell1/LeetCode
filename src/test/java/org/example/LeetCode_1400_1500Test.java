package org.example;

import lombok.val;
import org.example.util.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LeetCode_1400_1500Test {

    @Test
    void pseudoPalindromicPaths() {
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(1);

        TreeNode d = new TreeNode(3, a, b);
        TreeNode e = new TreeNode(1, null, c);
        TreeNode f = new TreeNode(2, d, e);

        val result = new LeetCode_1400_1500().pseudoPalindromicPaths(f);
        assertEquals(2, result);
    }
}