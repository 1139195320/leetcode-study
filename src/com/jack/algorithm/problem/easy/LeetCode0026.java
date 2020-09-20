package com.jack.algorithm.problem.easy;

import java.util.Arrays;

/**
 * @author jack
 */
public class LeetCode0026 {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int cur = nums[0];
        int curIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != cur) {
                cur = nums[i];
                nums[curIndex ++] = cur;
            }
        }
        return curIndex;
    }

    public static void main(String[] args) {
        LeetCode0026 main = new LeetCode0026();
        int[] arr1 = new int[] {1, 1, 2};
        int[] arr2 = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(main.removeDuplicates(arr1));
        System.out.println(Arrays.toString(arr1));
        System.out.println(main.removeDuplicates(arr2));
        System.out.println(Arrays.toString(arr2));
    }
}
