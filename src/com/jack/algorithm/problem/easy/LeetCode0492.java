package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0492 {

    public int[] constructRectangle(int area) {
        int max = (int) Math.sqrt(area);
        if (max * max == area) {
            return new int[]{max, max};
        }
        int w = 1;
        for (int i = max; i > 0; i--) {
            if (area % i == 0) {
                w = i;
                break;
            }
        }
        return new int[]{area / w, w};
    }
}
