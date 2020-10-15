package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0836 {

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if (rec1[0] == rec1[2] || rec1[1] == rec1[3]) {
            // rec1 无面积
            return false;
        }
        if (rec2[0] == rec2[2] || rec2[1] == rec2[3]) {
            // rec2 无面积
            return false;
        }
        return !(isLeft(rec2[2], rec2[3], rec1[0], rec1[1])
                || isLeft(rec1[2], rec1[3], rec2[0], rec2[1]));
    }
    private boolean isLeft(int x1, int y1, int x2, int y2) {
        return x1 <= x2 || y1 <= y2;
    }
}
