package com.jack.algorithm.problem.hard;

/**
 * @author jack
 */
public class LeetCode0239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        int[] res = new int[nums.length - k + 1];
        for (int i = k - 1; i < nums.length; i++) {
            int lIndex = i - k + 1;
            res[lIndex] = getMaxInArr(nums, lIndex, i);
        }
        return res;
    }
    private int getMaxInArr(int[] nums, int lIndex, int rIndex) {
        int maxNum = nums[lIndex];
        for (int i = lIndex + 1; i <= rIndex; i++) {
            maxNum = Math.max(maxNum, nums[i]);
        }
        return maxNum;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        int[] res = new int[nums.length - k + 1];
        for (int i = k - 1; i < nums.length; i++) {
            int lIndex = i - k + 1;
            if (preMaxIndex >= lIndex) {
                if (nums[i] >= nums[preMaxIndex]) {
                    preMaxIndex = i;
                }
                res[lIndex] = nums[preMaxIndex];
            } else {
                res[lIndex] = getMaxInArr2(nums, lIndex, i);
            }
        }
        return res;
    }
    private int preMaxIndex = -1;
    private int getMaxInArr2(int[] nums, int lIndex, int rIndex) {
        int maxNum = nums[lIndex];
        preMaxIndex = lIndex;
        for (int i = lIndex + 1; i <= rIndex; i++) {
            if (nums[i] >= maxNum) {
                maxNum = nums[i];
                preMaxIndex = i;
            }
        }
        return maxNum;
    }
}
