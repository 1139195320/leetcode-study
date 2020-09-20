package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0035 {

    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }

    public int searchInsert2(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        if (l == r) {
            return target > nums[r] ? 1 : 0;
        }
        int m;
        while (l < r) {
            if (r - l == 1) {
                if (target > nums[r]) {
                    return r + 1;
                }
                else if (target == nums[r]) {
                    return r;
                }
                else if (target <= nums[l]) {
                    return l;
                }
                else {
                    return r;
                }
            }
            m = (l + r) >> 1;
            if (target == nums[m]) {
                return m;
            }
            else if (target > nums[m]) {
                l = m;
            }
            else {
                r = m;
            }
        }
        return r;
    }
}
