package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode1503 {

    public int getLastMoment(int n, int[] left, int[] right) {
        // 两只相遇的蚂蚁同时改变移动方向之后的情形等价于两只蚂蚁都不改变移动方向
        int max = 0, min = n;
        for (int i : left) {
            max = Math.max(max, i);
        }
        for (int i : right) {
            min = Math.min(min, i);
        }
        return Math.max(max, n - min);
    }
}
