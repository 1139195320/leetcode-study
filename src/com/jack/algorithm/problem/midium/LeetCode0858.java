package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0858 {

    public int mirrorReflection(int p, int q) {
        int g = gcd(p, q);
        p /= g;
        q /= g;
        p %= 2;
        q %= 2;
        if (p == 1 && q == 1) {
            return 1;
        }
        return p == 1 ? 0 : 2;
    }
    private int gcd(int a, int b) {
        // 求两个数的最大公约数
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }
}
