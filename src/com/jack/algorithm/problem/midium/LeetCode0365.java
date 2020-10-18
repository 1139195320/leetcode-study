package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0365 {

    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) {
            return false;
        }
        if (x == 0 || y == 0) {
            return z == 0 || x + y == z;
        }
        return z % gcd(x, y) == 0;
    }
    private int gcd(int x, int y) {
        // 求两个数的最大公约数
        int tmp = x % y;
        while (tmp != 0) {
            x = y;
            y = tmp;
            tmp = x % y;
        }
        return y;
    }
}
