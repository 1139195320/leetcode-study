package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0342 {

    public boolean isPowerOfFour(int num) {
        if (num < 1) {
            return false;
        }
        else if (num == 1) {
            return true;
        }
        if ((num & 1) != 0 || (num & 2) != 0) {
            return false;
        }
        int i = 0, j = 0;
        for (int k = 2; k < 32; k++) {
            int tmp = 1 << k;
            if (tmp > num) {
                break;
            }
            if ((num & tmp) == 0) {
                continue;
            }
            if ((k & 1) == 0) {
                i ++;
            } else {
                j ++;
            }
            if (i > 1 || j > 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isPowerOfFour2(int num) {
        return num > 0 && (num & (num - 1)) == 0
                && (num & 0xaaaaaaaa) == 0;
    }
}
