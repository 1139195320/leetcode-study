package com.jack.algorithm.problem.midium;

import java.util.LinkedList;

/**
 * @author jack
 *
 * 存在 a ... c ... b
 * a < b < c
 */
public class LeetCode0456 {

    public boolean find12find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        // bStack 里面存 b，底最大，往上递减
        LinkedList<Integer> bStack = new LinkedList<>();
        // minA 里面存 a，每个值是前面一段的最小值
        int[] minA = new int[nums.length];
        minA[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            minA[i] = Math.min(minA[i - 1], nums[i]);
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            int curK = nums[i];
            // 若 k 比 a 大
            if (curK > minA[i]) {
                // 去掉比此处 a 小的 b
                while (!bStack.isEmpty() && bStack.peek() <= minA[i]) {
                    bStack.pop();
                }
                // 且 k 比 b 大
                if (!bStack.isEmpty() && bStack.peek() < curK) {
                    return true;
                }
                bStack.push(nums[i]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode0456 main = new LeetCode0456();
        System.out.println(main.find12find132pattern(new int[]{1, 2, 3, 4}));
        System.out.println(main.find12find132pattern(new int[]{4, 3, 2, 1}));
        System.out.println(main.find12find132pattern(new int[]{1, 4, 3, 2}));
        System.out.println(main.find12find132pattern(new int[]{-1, 3, 2, 0}));
    }
}