package com.jack.algorithm.problem.midium;

import java.util.Stack;

/**
 * @author jack
 */
public class LeetCode1249 {

    public String minRemoveToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int left = 0;
        int balance = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                left ++;
                stack.push(c);
            } else if (c == ')') {
                if (balance < left) {
                    stack.push(c);
                    balance ++;
                }
            } else {
                stack.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            if (c == '(') {
                if (balance == 0) {
                    continue;
                } else {
                    balance --;
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode1249 main = new LeetCode1249();
        System.out.println(main.minRemoveToMakeValid("lee(t(c)o)de)" ));
        System.out.println(main.minRemoveToMakeValid("a)b(c)d"));
        System.out.println(main.minRemoveToMakeValid("))(("));
        System.out.println(main.minRemoveToMakeValid( "(a(b(c)d)"));
        System.out.println(main.minRemoveToMakeValid( "())()((("));
    }
}