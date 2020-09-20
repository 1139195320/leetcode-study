package com.jack.algorithm.problem.midium;

import java.util.Stack;

/**
 * @author jack
 */
public class LeetCode0921 {

    public int minAddToMakeValid(String S) {
        Stack<Character> stack = new Stack<>();
        int need = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (!stack.empty()) {
                    stack.pop();
                } else {
                    need ++;
                }
            }
        }
        return need + stack.size();
    }

    public static void main(String[] args) {
        LeetCode0921 main = new LeetCode0921();
        // 1
        System.out.println(main.minAddToMakeValid("())"));
        // 3
        System.out.println(main.minAddToMakeValid("((("));
        // 0
        System.out.println(main.minAddToMakeValid("()"));
        // 4
        System.out.println(main.minAddToMakeValid("()))(("));
    }
}