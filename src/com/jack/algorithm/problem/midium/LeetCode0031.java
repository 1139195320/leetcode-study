package com.jack.algorithm.problem.midium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jack
 */
public class LeetCode0031 {

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        boolean find = false;
        int len = nums.length;
        int pre = nums[len - 1];
        Map<Integer, Integer> map = new HashMap<>(9);
        map.put(pre, len - 1);
        int index = len - 1;
        for (int i = len - 2; i >= 0; i--) {
            int cur = nums[i];
            if (cur < pre) {
                find = true;
                index = i;
                break;
            } else {
                map.put(cur, i);
                pre = cur;
            }
        }
        if (find) {
            int tIndex = index + 1;
            int minMax = pre;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int key = entry.getKey();
                if (key < minMax && key > nums[index]) {
                    minMax = entry.getKey();
                    tIndex = entry.getValue();
                }
            }
            swap(nums, index, tIndex);
            Arrays.sort(nums, index + 1, len);
        } else {
            Arrays.sort(nums);
        }
    }
    private void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }

    private void test1() {
        int[] arr = new int[] {1, 2, 3};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

    private void test2() {
        int[] arr = new int[] {3, 2, 1};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

    private void test3() {
        int[] arr = new int[] {1, 1, 5};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        LeetCode0031 main = new LeetCode0031();
        main.test1();
        main.test2();
        main.test3();
    }
}