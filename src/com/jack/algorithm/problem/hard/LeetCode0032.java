package com.jack.algorithm.problem.hard;

import java.util.Stack;

/**
 * @author jack
 */
public class LeetCode0032 {

    public int longestValidParentheses(String str) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }
        return res;
    }

    public int longestValidParentheses2(String str) {
        int left = 0;
        int right = 0;
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                left ++;
            } else {
                right ++;
            }
            if (left == right) {
                res = Math.max(res, right * 2);
            } else if (right >= left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = str.length() - 1; i > 0; i--) {
            if (str.charAt(i) == '(') {
                left ++;
            } else {
                right ++;
            }
            if (left == right) {
                res = Math.max(res, left * 2);
            } else if (left >= right) {
                left = right = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0032 main = new LeetCode0032();
        System.out.println(main.longestValidParentheses(")()())()()("));
        System.out.println(main.longestValidParentheses(")(((((()())()()))()(()))("));
        System.out.println(main.longestValidParentheses("())"));
        System.out.println(main.longestValidParentheses("()())"));
        System.out.println(main.longestValidParentheses("(())()"));
        System.out.println(main.longestValidParentheses(")()()("));
        System.out.println(main.longestValidParentheses("(())()(("));
        System.out.println(main.longestValidParentheses("(())()))()()((()))("));
    }
}