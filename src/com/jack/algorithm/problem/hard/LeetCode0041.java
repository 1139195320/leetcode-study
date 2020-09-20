package com.jack.algorithm.problem.hard;

/**
 *
 * 缺失的第一个正数
 *
 * @author jack
 */
public class LeetCode0041 {

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int[] step = new int[n + 1];
        for (int num : nums) {
            if (num > 0) {
                if (num <= n) {
                    step[num] = 1;
                }
            }
        }
        int res = 1;
        boolean isFind = false;
        for (int i = 1; i < step.length; i++) {
            if (step[i] == 0) {
                res = i;
                isFind = true;
                break;
            }
        }
        if (!isFind) {
            res = n + 1;
        }
        return res;
    }

    public int firstMissingPositive2(int[] nums) {
        boolean[] flag = new boolean[nums.length + 1];
        for (int num : nums) {
            if (num > 0 && num <= nums.length) {
                flag[num] = true;
            }
        }
        int res = nums.length + 1;
        for (int i = 1; i < flag.length; i++) {
            if (!flag[i]) {
                res = i;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0041 main = new LeetCode0041();
        System.out.println(main.firstMissingPositive(new int[]{1}));
        System.out.println(main.firstMissingPositive(new int[]{1, 2}));
        System.out.println(main.firstMissingPositive(new int[]{1, 3}));
        System.out.println(main.firstMissingPositive(new int[]{1, 3, 4, 2}));
        System.out.println(main.firstMissingPositive(new int[]{1, 3, 7, 4}));
    }
}
