package com.jack.algorithm.problem.easy;

import java.util.Stack;

/**
 * @author jack
 */
public class LeetCode0155 {

    private static class MinStack {

        private Stack<Integer> dataStack;
        private Stack<Integer> nowMinStack;

        /** initialize your data structure here. */
        public MinStack() {
            dataStack = new Stack<>();
            nowMinStack = new Stack<>();
        }

        public void push(int x) {
            dataStack.push(x);
            if (nowMinStack.empty() || x <= nowMinStack.peek()) {
                nowMinStack.push(x);
            } else {
                nowMinStack.push(nowMinStack.peek());
            }
        }

        public void pop() {
            if (!dataStack.empty()) {
                dataStack.pop();
                nowMinStack.pop();
            }
        }

        public int top() {
            if (dataStack.empty()) {
                throw new RuntimeException();
            }
            return dataStack.peek();
        }

        public int getMin() {
            if (nowMinStack.empty()) {
                throw new RuntimeException();
            }
            return nowMinStack.peek();
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
