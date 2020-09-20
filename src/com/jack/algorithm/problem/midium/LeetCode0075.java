package com.jack.algorithm.problem.midium;

import java.util.Arrays;

/**
 * @author jack
 */
public class LeetCode0075 {

    public void sortColors(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int i = 0;
        while (i <= r) {
            if (nums[i] == 0) {
                if (i == l) {
                    i ++;
                } else {
                    swap(nums, i, l ++);
                }
            } else if (nums[i] == 2) {
                if (i == r) {
                    r --;
                } else {
                    swap(nums, i, r --);
                }
            }
            else {
                i ++;
            }
        }
    }
    private void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }

    public static void main(String[] args) {
        LeetCode0075 main = new LeetCode0075();
        int[] arr1 = new int[] {2, 0, 2, 1, 1, 0};
        int[] arr2 = new int[] {1, 0, 2, 0, 2, 1};
        main.sortColors(arr1);
        main.sortColors(arr2);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}