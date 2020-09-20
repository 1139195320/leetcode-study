package com.jack.algorithm.problem.easy;

import java.util.Arrays;

/**
 * @author jack
 */
public class LeetCode0628 {

    public int maximumProduct(int[] nums) {
        int n = nums.length;
        if (n == 3) {
            return nums[0] * nums[1] * nums[2];
        }
        Arrays.sort(nums);
        if (nums[n - 3] < 0) {
            // 至少有 2 个小于 0 的数
            // 且只有 2 个大于 0 的数
            return nums[n - 1] * nums[0] * nums[1];
        } else {
            // 至少有 3 个大于 0 的数
            if (nums[1] < 0) {
                // 至少有 2 个小于 0 的数
                return nums[n - 1] *
                        Math.max(nums[0] * nums[1],
                                nums[n - 2] * nums[n - 3]);
            } else {
                // 只有一个小于 0 的数
                return nums[n - 1] * nums[n - 2] * nums[n - 3];
            }
        }
    }

    public int maximumProduct2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        return nums[n - 1] * Math.max(nums[0] * nums[1],
                nums[n - 2] * nums[n - 3]);
    }

    public static void main(String[] args) {
        LeetCode0628 main = new LeetCode0628();
        System.out.println(main.maximumProduct(
                new int[] {1, 2, 3, 4}
        ));
    }
}