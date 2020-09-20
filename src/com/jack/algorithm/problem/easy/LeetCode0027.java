package com.jack.algorithm.problem.easy;

import java.util.Arrays;

/**
 * @author jack
 */
public class LeetCode0027 {

    public int removeElement(int[] nums, int val) {
        int res = 0;
        boolean flag = false;
        int l = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                if (!flag) {
                    l = i;
                    flag = true;
                }
            }
            else {
                res ++;
                if (flag) {
                    swap(nums, l, i);
                    l ++;
                }
            }
        }
        return res;
    }
    private void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }


    /**
     * 官方 双指针
     */
    public int removeElement2(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n --;
            } else {
                i ++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        LeetCode0027 main = new LeetCode0027();
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(main.removeElement(nums, 2));
        System.out.println(Arrays.toString(nums));
    }
}