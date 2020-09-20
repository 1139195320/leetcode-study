package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode10803 {

    public int findMagicIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i == nums[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LeetCode10803 main = new LeetCode10803();
    }
}