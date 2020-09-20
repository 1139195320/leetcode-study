package com.jack.algorithm.problem.midium;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author jack
 */
public class LeetCode0503 {

    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = -1;
            for (int j = i; j < i + nums.length; j++) {
                int index = j % nums.length;
                if (nums[index] > nums[i]) {
                    res[i] = nums[index];
                    break;
                }
            }
        }
        return res;
    }

    public int[] nextGreaterElements2(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            int index = i % nums.length;
            while (!stack.empty() && nums[stack.peek()] <= nums[index]) {
                stack.pop();
            }
            res[index] = stack.empty() ? -1 : nums[stack.peek()];
            stack.push(index);
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0503 main = new LeetCode0503();
        System.out.println(Arrays.toString(main.nextGreaterElements(
                new int[] {1, 2, 1}
        )));
        System.out.println(Arrays.toString(main.nextGreaterElements2(
                new int[] {1, 2, 1}
        )));
    }
}