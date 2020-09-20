package com.jack.algorithm.problem.hard;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author jack
 */
public class LeetCode0084 {

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        // 默认都有可能是从自身到最后一个
        Arrays.fill(right, n);
        Stack<Integer> monoStack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!monoStack.empty()
                    && heights[monoStack.peek()] >= heights[i]) {
                right[monoStack.pop()] = i;
            }
            left[i] = monoStack.empty() ? -1 : monoStack.peek();
            monoStack.push(i);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, (right[i] - (left[i] + 1)) * heights[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0084 main = new LeetCode0084();
        System.out.println(main.largestRectangleArea(
                new int[] {2, 1, 5, 6, 2, 3}));
    }
}