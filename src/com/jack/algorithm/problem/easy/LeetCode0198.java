package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0198 {

    public int rob(int[] nums) {
        int preMax = 0;
        int curMax = 0;
        for (int num : nums) {
            int temp = curMax;
            curMax = Math.max(preMax + num, curMax);
            preMax = temp;
        }
        return curMax;
    }

}
