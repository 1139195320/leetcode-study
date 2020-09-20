package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0034 {

    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return new int[] {-1, -1};
        }
        int l = 0;
        int r = n - 1;
        if (target < nums[l] || target > nums[r]) {
            return new int[] {-1, -1};
        }
        boolean find = false;
        int tIdx = 0;
        while (l < r - 1) {
            int m = (l + r) >> 1;
            if (nums[m] == target) {
                find = true;
                tIdx = m;
                break;
            }
            else if (nums[m] > target) {
                r = m;
            }
            else {
                l = m;
            }
        }
        if (nums[l] == target && nums[r] == target) {
            return new int[] {l, r};
        }
        if (nums[l] == target) {
            find = true;
            tIdx = l;
        }
        if (nums[r] == target) {
            find = true;
            tIdx = r;
        }
        if (find) {
            int tmpL = tIdx;
            while (tmpL - 1 >= 0 && nums[tmpL - 1] == target) {
                tmpL --;
            }
            int tmpR = tIdx;
            while (tmpR + 1 <= n - 1 && nums[tmpR + 1] == target) {
                tmpR ++;
            }
            return new int[] {tmpL, tmpR};
        }
        return new int[] {-1, -1};
    }
}
