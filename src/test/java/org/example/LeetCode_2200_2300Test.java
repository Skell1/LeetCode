package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LeetCode22002300Test {

    @Test
    void findWinners1() {
        List<List<Integer>> answ = new LeetCode_2200_2300().findWinners(new int[][]{{1,3},{2,3},{3,6},{5,6},{5,7},{4,5},{4,8},{4,9},{10,4},{10,9}});
        List<ArrayList<Object>> expected = new ArrayList<>();
        ArrayList<Object> win = new ArrayList<>();
        win.add(1);
        win.add(2);
        win.add(10);
        ArrayList<Object> own = new ArrayList<>();
        own.add(4);
        own.add(5);
        own.add(7);
        own.add(8);

        expected.add(win);
        expected.add(own);
        assertEquals(expected, answ);
    }

    @Test
    void findWinners2() {
        List<List<Integer>> answ = new LeetCode_2200_2300().findWinners(new int[][]{{1,5},{2,5},{2,8},{2,9},{3,8},{4,7},{4,9},{5,7},{ 6,8}});
        List<ArrayList<Object>> expected = new ArrayList<>();
        ArrayList<Object> win = new ArrayList<>();
        win.add(1);
        win.add(2);
        win.add(3);
        win.add(4);
        win.add(6);

        ArrayList<Object> own = new ArrayList<>();

        expected.add(win);
        expected.add(own);
        assertEquals(expected, answ);
    }
}