package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0162 {

    public int findPeakElement(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                if (i == nums.length - 1
                        || nums[i] > nums[i + 1]) {
                    return i;
                }
            }
        }
        return 0;
    }

    public int findPeakElement2(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n - 1;
        }
        return find(nums, 0 , n - 1);
    }
    private int find(int[] nums, int l, int r) {
        if (l == r) {
            return l;
        }
        int m = (l + r) >> 1;
        if (nums[m] > nums[m + 1]) {
            return find(nums, l, m);
        }
        return find(nums, m + 1, r);
    }

    public static void main(String[] args) {
        LeetCode0162 main = new LeetCode0162();
        System.out.println(main.findPeakElement(
                new int[]{1, 2, 3, 1}
        ));
        System.out.println(main.findPeakElement(
                new int[]{1, 2, 1, 3, 5, 6, 4}
        ));
        System.out.println(main.findPeakElement2(
                new int[]{1, 2, 3, 1}
        ));
        System.out.println(main.findPeakElement2(
                new int[]{1, 2, 1, 3, 5, 6, 4}
        ));
    }
}