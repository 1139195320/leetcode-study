package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode1009 {

    public int bitwiseComplement(int n) {
        if (n == 0) {
            return 1;
        }
        int tmp = 1;
        while (tmp <= n) {
            tmp <<= 1;
        }
        return n ^ (tmp - 1);
    }
}
