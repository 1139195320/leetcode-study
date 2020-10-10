package com.jack.algorithm.problem.easy;

import java.util.Stack;

/**
 * @author jack
 */
public class LeetCode0682 {

    public int calPoints(String[] ops) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (String op : ops) {
            if ("C".equals(op)) {
                res -= stack.peek();
                stack.pop();
            } else if ("D".equals(op)) {
                int cur = stack.peek() << 1;
                res += cur;
                stack.push(cur);
            } else if ("+".equals(op)) {
                int cur = stack.get(stack.size() - 2) + stack.peek();
                res += cur;
                stack.push(cur);
            } else {
                int cur = Integer.parseInt(op);
                res += cur;
                stack.push(cur);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0682 main = new LeetCode0682();
        System.out.println(main.calPoints(
                new String[]{"5", "2", "C", "D", "+"}
        ));
        System.out.println(main.calPoints(
                new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"}
        ));
    }
}