package com.jack.algorithm.problem.midium;

import java.util.Stack;

/**
 * @author jack
 */
public class LeetCode0946 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        boolean a = pushed == null || pushed.length == 0;
        boolean b = popped == null || popped.length == 0;
        if (a && b) {
            return true;
        }
        if (a || b) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int i = 1;
        int j = 0;
        stack.push(pushed[0]);
        while (true) {
            while (!stack.empty()) {
                if (stack.peek() == popped[j]) {
                    stack.pop();
                    j++;
                } else {
                    break;
                }
            }
            if (i == pushed.length) {
                break;
            }
            stack.push(pushed[i++]);
        }
        return stack.empty() && j == popped.length;
    }

    public static void main(String[] args) {
        LeetCode0946 main = new LeetCode0946();
        System.out.println(main.validateStackSequences(
                new int[]{1, 2, 3, 4, 5},
                new int[]{4, 5, 3, 2, 1}
        ));
        System.out.println(main.validateStackSequences(
                new int[]{1, 2, 3, 4, 5},
                new int[]{4, 3, 5, 1, 2}
        ));
        System.out.println(main.validateStackSequences(
                new int[]{1, 2, 5, 4, 3},
                new int[]{2, 1, 4, 3, 5}
        ));
        System.out.println(main.validateStackSequences(
                new int[]{1, 2, 5, 4, 3},
                new int[]{2, 1, 4, 5, 3}
        ));
        System.out.println(main.validateStackSequences(
                new int[]{1, 2, 5, 4, 3},
                new int[]{2, 1, 3, 4, 5}
        ));
        System.out.println(main.validateStackSequences(
                new int[]{1, 2, 5, 4, 3},
                new int[]{4, 3, 2, 5, 1}
        ));
    }
}