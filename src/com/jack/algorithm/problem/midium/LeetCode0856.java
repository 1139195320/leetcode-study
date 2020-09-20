package com.jack.algorithm.problem.midium;

import java.util.Stack;

/**
 * @author jack
 */
public class LeetCode0856 {

    public int scoreOfParentheses(String S) {
        if (S == null) {
            return 0;
        }
        S = S.trim();
        if (S.length() == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push(0);
            } else {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x + Math.max(y << 1, 1));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        LeetCode0856 main = new LeetCode0856();
        System.out.println(main.scoreOfParentheses("()()"));
        System.out.println(main.scoreOfParentheses("(()())"));
        System.out.println(main.scoreOfParentheses("(()(()))"));
    }
}