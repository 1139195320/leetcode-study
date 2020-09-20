package com.jack.algorithm.problem.midium;

import java.util.Arrays;

/**
 * @author jack
 */
public class LeetCode0215 {

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        LeetCode0215 main = new LeetCode0215();
        System.out.println(main.findKthLargest(
                new int[]{
                        3, 2, 3, 1, 2, 4, 5, 5, 6
                }, 4
        ));
    }
}