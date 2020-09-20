package com.jack.algorithm.problem.hard;

import java.util.Arrays;

/**
 * @author jack
 */
public class LeetCode0154 {

    public int findMin(int[] nums) {
        Arrays.sort(nums);
        return nums[0];
    }

    public int findMin2(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int m = l + ((r - l) >> 1);
            if (nums[m] < nums[r]) {
                r = m;
            }
            else if (nums[m] > nums[r]) {
                l = m + 1;
            }
            else {
                r -= 1;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        LeetCode0154 main = new LeetCode0154();
        System.out.println(main.findMin2(
                new int[]{2, 2, 2, 3, 4, 0, 0, 0, 0, 1, 1, 1, 1}
        ));
    }
}