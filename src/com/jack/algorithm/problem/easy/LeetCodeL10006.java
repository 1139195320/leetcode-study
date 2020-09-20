package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCodeL10006 {

    public int minCount(int[] coins) {
        int res = 0;
        for (int coin : coins) {
            int a = coin >> 1;
            int b = coin & 1;
            res += a + b;
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCodeL10006 main = new LeetCodeL10006();
    }
}