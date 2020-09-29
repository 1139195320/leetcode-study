package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode1486 {

    public int xorOperation(int n, int start) {
        int res = start;
        for (int i = 1; i < n; i++) {
            res ^= (start + (i << 1));
        }
        return res;
    }
}
