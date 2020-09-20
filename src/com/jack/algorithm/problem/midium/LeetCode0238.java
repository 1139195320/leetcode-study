package com.jack.algorithm.problem.midium;

import java.util.Arrays;

/**
 * @author jack
 */
public class LeetCode0238 {

    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length];
        int len = nums.length;
        res[0] = 1;
        // 先遍历一遍，res 存储每个数左边的乘积
        for (int i = 1; i < len; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int tmp = 1;
        // 再遍历一遍，res 乘上每个数右边的乘积
        for (int i = len - 1; i >= 0; i--) {
            res[i] = res[i] * tmp;
            tmp *= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0238 main = new LeetCode0238();
        System.out.println(Arrays.toString(main.productExceptSelf(
                new int[] {2}
        )));
        System.out.println(Arrays.toString(main.productExceptSelf(
                new int[] {}
        )));
        System.out.println(Arrays.toString(main.productExceptSelf(
                new int[] {1, 2, 3, 4}
        )));
        System.out.println(Arrays.toString(main.productExceptSelf(
                new int[] {1, 0, 2, 3, 4}
        )));
    }
}