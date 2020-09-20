package com.jack.algorithm.problem.midium;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jack
 */
public class LeetCode10059 {

    private static class MaxQueue {

        private Queue<Integer> queue;
        private Deque<Integer> deque;

        public MaxQueue() {
            queue = new LinkedList<>();
            deque = new LinkedList<>();
        }

        public int max_value() {
            Integer first = deque.peekFirst();
            return first != null ? first : -1;
        }

        public void push_back(int value) {
            while (!deque.isEmpty() && deque.peekLast() < value) {
                deque.pollLast();
            }
            deque.addLast(value);
            queue.add(value);
        }

        public int pop_front() {
            Integer first = queue.poll();
            int res = first != null ? first : -1;
            if (!deque.isEmpty() && res == deque.peekFirst()) {
                deque.pollFirst();
            }
            return res;
        }
    }

    public static void main(String[] args) {
        MaxQueue queue = new MaxQueue();
        queue.push_back(15);
        queue.push_back(9);
        System.out.println(queue.max_value());
        System.out.println(queue.pop_front());
        System.out.println(queue.max_value());
    }
}
