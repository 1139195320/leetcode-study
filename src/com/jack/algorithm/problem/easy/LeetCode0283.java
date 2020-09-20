package com.jack.algorithm.problem.easy;

import java.util.Arrays;

/**
 * @author jack
 */
public class LeetCode0283 {

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int l = 0;
        boolean flag = false;
        int r = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (cur == 0) {
                if (!flag) {
                    l = i;
                    flag = true;
                }
            } else {
                r = i;
            }
            if (l < r && flag) {
                swap(nums, l, r);
                l ++;
                r = l;
            }
        }
    }
    private void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }

    /**
     * 官方 双指针
     */
    public void moveZeroes2(int[] nums) {
        int lastNonZeroFoundAt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroFoundAt ++] = nums[i];
            }
        }
        for (int i = lastNonZeroFoundAt; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * 官方 最优解
     */
    public void moveZeroes3(int[] nums) {
        for (int lastNonZeroFoundAt = 0, cur = 0; cur < nums.length; cur++) {
            if (nums[cur] != 0) {
                swap(nums, lastNonZeroFoundAt ++, cur);
            }
        }
    }

    public static void main(String[] args) {
        LeetCode0283 main = new LeetCode0283();
        int[] nums = new int[]{0, 1, 0, 3, 12};
        main.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}