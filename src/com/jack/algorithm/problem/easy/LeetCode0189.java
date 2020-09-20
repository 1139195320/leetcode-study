package com.jack.algorithm.problem.easy;

import java.util.Arrays;

/**
 * @author jack
 *
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 *
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 *
 */
public class LeetCode0189 {

    /**
     * 基础普通 求解
     */
    public void rotate(int[] nums, int k) {
        if (nums != null && nums.length > 1) {
            k %= nums.length;
            int [] res = new int[nums.length];
            System.arraycopy(nums, 0, res, k, nums.length - k);
            System.arraycopy(nums, nums.length - k, res, 0, k);
            System.arraycopy(res, 0, nums, 0, nums.length);
        }
    }

    /**
     * 环状替换 求解
     */
    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        int count = 0;
        for (int i = 0; count < nums.length; i++) {
            int cur = i;
            int pre = nums[i];
            do {
                int next = (cur + k) % nums.length;
                int tmp = nums[next];
                nums[next] = pre;
                pre = tmp;
                cur = next;
                count ++;
            } while (i != cur);
        }
    }

    /**
     * 使用反转 求解
     */
    public void rotate3(int[] nums, int k) {
        k %= nums.length;
        // 1.反转全部元素
        reverse(nums, 0, nums.length - 1);
        // 2.反转前 k 个元素
        reverse(nums, 0, k - 1);
        // 3.反转后 n - k 个元素
        reverse(nums, k, nums.length - 1);
    }
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start ++;
            end --;
        }
    }

    public static void main(String[] args) {
        LeetCode0189 main = new LeetCode0189();
        main.test1();
        main.test2();
    }
    private void test1() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(nums));
        rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
    private void test2() {
        int[] nums = new int[]{-1,-100,3,99};
        System.out.println(Arrays.toString(nums));
        rotate(nums, 2);
        System.out.println(Arrays.toString(nums));
    }
}