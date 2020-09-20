package com.jack.algorithm.problem.midium;

import java.util.Arrays;

/**
 * @author jack
 */
public class LeetCode0153 {

    public int findMin(int[] nums) {
        Arrays.sort(nums);
        return nums[0];
    }

    public int findMin2(int[] nums) {
        int n = nums.length;
        return find(nums, 0, n - 1);
    }
    private int find(int[] nums, int l, int r) {
        if (r - l <= 1) {
            return Math.min(nums[l], nums[r]);
        }
        int m = (l + r) >> 1;
        int cur = nums[m];
        int curL = nums[l];
        int curR = nums[r];
        if (cur > curL && cur < curR) {
            return nums[0];
        }
        if (cur < curL && cur < curR) {
            return find(nums, l, m);
        }
        if (cur > curL && cur > curR) {
            return find(nums, m, r);
        }
        return nums[0];
    }

    public static void main(String[] args) {
        LeetCode0153 main = new LeetCode0153();
        System.out.println(main.findMin(
                new int[]{3, 4, 5, 1, 2}
        ));
        System.out.println(main.findMin(
                new int[]{4, 5, 6, 7, 0, 1, 2}
        ));
        System.out.println(main.findMin2(
                new int[]{3, 4, 5, 1, 2}
        ));
        System.out.println(main.findMin2(
                new int[]{4, 5, 6, 7, 0, 1, 2}
        ));
    }
}