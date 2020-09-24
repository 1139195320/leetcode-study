package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode11607 {

    public int maximum(int a, int b) {
        // Max(a, b) = (|a - b| + a + b) / 2
        return (int) ((Math.abs((long) a - (long) b) + (long) a + (long) b) >> 1);
    }
}
