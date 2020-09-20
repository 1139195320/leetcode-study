package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode10053 {

    public int missingNumber(int[] nums) {
        int tmp = 0;
        for (int num : nums) {
            if (num != tmp) {
                break;
            }
            tmp++;
        }
        return tmp;
    }
}
