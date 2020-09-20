package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0371 {

    public int getSum(int a, int b) {
        while (b != 0) {
            // 进位
            int tmp = (a & b) << 1;
            a ^= b;
            b = tmp;
        }
        return a;
    }
}
