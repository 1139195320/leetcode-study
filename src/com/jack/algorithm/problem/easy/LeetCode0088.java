package com.jack.algorithm.problem.easy;

import java.util.Arrays;

/**
 * @author jack
 */
public class LeetCode0088 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m >= 0) {
            System.arraycopy(nums1, 0, nums1, n, m);
        }
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m || j < n) {
            int cur;
            if (i < m && j < n) {
                if (nums1[i + n] <= nums2[j]) {
                    cur = nums1[i + n];
                    i ++;
                } else {
                    cur = nums2[j ++];
                }
            } else {
                if (i < m) {
                    cur = nums1[i + n];
                    i ++;
                } else {
                    cur = nums2[j ++];
                }
            }
            nums1[k ++] = cur;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{2, 0, 0, 0};
        int[] nums2 = new int[]{1};
        LeetCode0088 main = new LeetCode0088();
        main.merge(nums1, 1, nums2, 1);
        System.out.println(Arrays.toString(nums1));
    }
}