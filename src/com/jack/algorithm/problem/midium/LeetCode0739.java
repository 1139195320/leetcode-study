package com.jack.algorithm.problem.midium;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author jack
 */
public class LeetCode0739 {

    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            res[i] = 0;
            if (T[i] == 100) {
                continue;
            }
            for (int j = i + 1; j < T.length; j++) {
                if (T[j] > T[i]) {
                    res[i] = j - i;
                    break;
                }
            }
        }
        return res;
    }

    public int[] dailyTemperatures2(int[] T) {
        int[] res = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = T.length - 1; i >= 0; i--) {
            while (!stack.empty() && T[stack.peek()] <= T[i]) {
                stack.pop();
            }
            res[i] = stack.empty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0739 main = new LeetCode0739();
        // 2, 1, 4, 3, 2, 1, 0
        System.out.println(Arrays.toString(main.dailyTemperatures(
                new int[] {73, 72, 75, 74, 69, 68, 76}
        )));
        System.out.println(Arrays.toString(main.dailyTemperatures2(
                new int[] {73, 72, 75, 74, 69, 68, 76}
        )));
    }
}