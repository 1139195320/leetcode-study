package com.jack.algorithm.problem.midium;

import java.util.Stack;

/**
 * @author jack
 */
public class LeetCode0150 {

    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<String> numStack = new Stack<>();
        for (String token : tokens) {
            if ("+".equals(token)) {
                int b = Integer.parseInt(numStack.pop());
                int a = Integer.parseInt(numStack.pop());
                numStack.push((a + b) + "");
            } else if ("-".equals(token)) {
                int b = Integer.parseInt(numStack.pop());
                int a = Integer.parseInt(numStack.pop());
                numStack.push((a - b) + "");
            } else if ("*".equals(token)) {
                int b = Integer.parseInt(numStack.pop());
                int a = Integer.parseInt(numStack.pop());
                numStack.push((a * b) + "");
            } else if ("/".equals(token)) {
                int b = Integer.parseInt(numStack.pop());
                int a = Integer.parseInt(numStack.pop());
                numStack.push((a / b) + "");
            } else {
                numStack.push(token);
            }
        }
        return Integer.parseInt(numStack.pop());
    }

    public static void main(String[] args) {
        LeetCode0150 main = new LeetCode0150();
        System.out.println(main.evalRPN(new String[]{
                "4", "13", "5", "/", "+"
        }));
        System.out.println(main.evalRPN(new String[]{
                "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"
        }));
    }
}