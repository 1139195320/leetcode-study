package com.jack.algorithm.problem.midium;

import java.util.Arrays;

/**
 * @author jack
 * 给你一个整数数组 nums，请你将该数组升序排列。
 *
 * 示例 1：
 *
 * 输入：nums = [5,2,3,1]
 * 输出：[1,2,3,5]
 * 示例 2：
 *
 * 输入：nums = [5,1,1,2,0,0]
 * 输出：[0,0,1,1,2,5]
 *
 */
public class LeetCode0912 {

    public int[] sortArray(int[] nums) {
//        Arrays.sort(nums);
//        insertSort(nums);
        shellSort(nums);
        return nums;
    }

    /**
     * 希尔排序
     **/
    private void shellSort(int[] nums) {
        int len = nums.length;
        int tmp, gap = len >> 1;
        while (gap > 0) {
            for (int i = gap; i < len; i ++) {
                tmp = nums[i];
                int preI = i - gap;
                while (preI >= 0 && tmp < nums[preI]) {
                    nums[preI + gap] = nums[preI];
                    preI -= gap;
                }
                nums[preI + gap] = tmp;
            }
            gap >>= 1;
        }
    }

    /**
     * 插入排序
     **/
    private void insertSort(int[] nums) {
        int cur;
        for (int i = 0; i < nums.length - 1; i++) {
            cur = nums[i + 1];
            int preI = i;
            while (preI >= 0 && cur < nums[preI]) {
                nums[preI + 1] = nums[preI];
                preI --;
            }
            nums[preI + 1] = cur;
        }
    }

    public static void main(String[] args) {
        LeetCode0912 main = new LeetCode0912();
        System.out.println(Arrays.toString(main.sortArray(new int[]{5, 2, 3, 1})));
//        System.out.println(Arrays.toString(main.sortArray(new int[]{5, 1, 1, 2, 0, 0})));
    }
}