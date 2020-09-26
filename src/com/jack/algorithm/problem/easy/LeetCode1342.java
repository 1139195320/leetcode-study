package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode1342 {

    public int numberOfSteps(int num) {
        int res = 0;
        while (num > 0) {
            if ((num & 1) == 0) {
                num >>= 1;
            } else {
                num --;
            }
            res ++;
        }
        return res;
    }
}
