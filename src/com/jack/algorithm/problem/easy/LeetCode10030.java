package com.jack.algorithm.problem.easy;

import java.util.Stack;

/**
 * @author jack
 */
public class LeetCode10030 {

    private static class MinStack {

        private Stack<Integer> dataStack;
        private Stack<Integer> curMinStack;

        public MinStack() {
            dataStack = new Stack<>();
            curMinStack = new Stack<>();
        }

        public void push(int x) {
            dataStack.push(x);
            if (curMinStack.empty() || curMinStack.peek() >= x) {
                curMinStack.push(x);
            }
        }

        public void pop() {
            int x = dataStack.pop();
            if (!curMinStack.empty() && x == curMinStack.peek()) {
                curMinStack.pop();
            }
        }

        public int top() {
            return dataStack.peek();
        }

        public int min() {
            return curMinStack.peek();
        }
    }
}
