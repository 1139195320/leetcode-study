package com.jack.algorithm.problem.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jack
 */
public class LeetCode0933 {

    public static void main(String[] args) {
        RecentCounter counter = new RecentCounter();
        System.out.println(counter.ping(1));
        System.out.println(counter.ping(100));
        System.out.println(counter.ping(3001));
        System.out.println(counter.ping(3002));
    }
}

class RecentCounter {

    private Queue<Integer> queue;
    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.add(t);
        while (!queue.isEmpty()
                && queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }
}