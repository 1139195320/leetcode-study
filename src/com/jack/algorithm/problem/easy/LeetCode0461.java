package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0461 {

    public int hammingDistance(int m, int n) {
        m ^= n;
        int res = 0;
        while (m != 0) {
            if (m % 2 == 1) {
                res ++;
            }
            m >>= 1;
        }
        return res;
    }

    public int hammingDistance2(int m, int n) {
        return Integer.bitCount(m ^ n);
    }

    public static void main(String[] args) {
        LeetCode0461 main = new LeetCode0461();
        System.out.println(main.hammingDistance(1, 4));
        System.out.println(main.hammingDistance2(1, 4));
    }
}