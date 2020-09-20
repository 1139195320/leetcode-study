package com.jack.algorithm.problem.midium;

/**
 * @author fy
 */
public class LeetCode0033 {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int lIndex = 0;
        int rIndex = nums.length - 1;
        int mIndex = (lIndex + rIndex + 1) / 2;
        int tIndex = -1;
        while (lIndex < rIndex) {
            if (target == nums[lIndex]) {
                tIndex = lIndex;
                break;
            }
            if (target == nums[mIndex]) {
                tIndex = mIndex;
                break;
            }
            if (target == nums[rIndex]) {
                tIndex = rIndex;
                break;
            }
            if (rIndex - lIndex == 1) {
                break;
            }
            if (target < nums[lIndex] && target > nums[rIndex]) {
                // no result
                break;
            }
            if (nums[mIndex] > nums[lIndex]) {
                // l < m
                if (nums[mIndex] < target || target < nums[lIndex]) {
                    // l < m < t
                    // t < l < m
                    lIndex = mIndex;
                } else {
                    rIndex = mIndex;
                }
            } else {
                // m < l
                if (target > nums[lIndex] || target < nums[mIndex]) {
                    // m < l < t
                    // t < m < l
                    rIndex = mIndex;
                } else {
                    lIndex = mIndex;
                }
            }
            mIndex = (lIndex + rIndex) / 2;
        }
        return tIndex;
    }

    public static void main(String[] args) {
        LeetCode0033 main = new LeetCode0033();
        System.out.println(main.search(
                new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(main.search(
                new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(main.search(
                new int[]{1, 4, 3}, 0));
        System.out.println(main.search(
                new int[]{1, 3}, 0));
        System.out.println(main.search(
                new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 8));
        System.out.println(main.search(
                new int[]{7, 8, 1, 2, 3, 4, 5, 6}, 2));
        System.out.println(main.search(
                new int[]{4, 5, 6, 7, 0, 1, 2}, 6));
    }
}
