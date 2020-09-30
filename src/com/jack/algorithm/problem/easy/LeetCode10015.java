package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode10015 {

    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }

    public int hammingWeight2(int n) {
        int res = 0;
        while (n != 0) {
            res ++;
            n &= (n - 1);
        }
        return res;
    }
}
