package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode10501 {

    public int insertBits(int N, int M, int i, int j) {
        // i-j 的 N 清零
        for (int k = i; k <= j; k++) {
            int tmp = 1 << k;
            if ((N & tmp) != 0) {
                N -= tmp;
            }
        }
        // 将 M 移位 加进 N
        N += (M << i);
        return N;
    }

    public int insertBits2(int N, int M, int i, int j) {
        // i-j 全 1，其余全 0
        int mask = ((1 << (j - i + 1)) - 1) << i;
        // i-j 全 0，其余全 1
        mask = ~mask;
        // i-j 的 N 清零
        N &= mask;
        return N | (M << i);
    }
}
