package com.jack.algorithm.problem.midium;

import java.util.Arrays;

/**
 * @author jack
 */
public class LeetCode0080 {

    public int removeDuplicates(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (k < 2 || nums[k - 2] < nums[i]) {
                nums[k ++] = nums[i];
            }
        }
        return k;
    }

    public static void main(String[] args) {
        LeetCode0080 main = new LeetCode0080();
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        System.out.println(main.removeDuplicates(nums1));
        System.out.println(Arrays.toString(nums1));
        int[] nums2 = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(main.removeDuplicates(nums2));
        System.out.println(Arrays.toString(nums2));
    }
}