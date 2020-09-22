package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0693 {

    public boolean hasAlternatingBits(int n) {
        int max = 1;
        if (n > (Integer.MAX_VALUE >> 1)) {
            max = Integer.MAX_VALUE >> 1;
            max += 1;
        } else {
            while (max <= n) {
                max <<= 1;
            }
            max >>= 1;
        }
        boolean preZero = false;
        max >>= 1;
        while (max > 0) {
            boolean curZero = (n & max) == 0;
            if (preZero == curZero) {
                return false;
            }
            preZero = curZero;
            max >>= 1;
        }
        return true;
    }

    public boolean hasAlternatingBits2(int n) {
        boolean preZero = n % 2 == 0;
        n >>= 1;
        while (n > 0) {
            boolean curZero = n % 2 == 0;
            if (preZero == curZero) {
                return false;
            }
            preZero = curZero;
            n >>= 1;
        }
        return true;
    }
}
