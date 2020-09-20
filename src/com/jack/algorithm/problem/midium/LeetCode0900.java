package com.jack.algorithm.problem.midium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jack
 */
public class LeetCode0900 {

    public static void main(String[] args) {
        RLEIterator iterator = new RLEIterator(
                new int[]{3, 8, 0, 9, 2, 5}
        );
        System.out.println(iterator.next(2));
        System.out.println(iterator.next(1));
        System.out.println(iterator.next(1));
        System.out.println(iterator.next(2));
    }
}

class RLEIterator {

    private int[] A;
    private Queue<Integer> queue;
    public RLEIterator(int[] A) {
        this.A = A;
        this.queue = new LinkedList<>();
        for (int i = 1; i < A.length; i += 2) {
            if (A[i - 1] > 0) {
                queue.add(i);
            }
        }
    }

    public int next(int n) {
        int count = 0;
        while (!queue.isEmpty()
                && (count = count + A[queue.peek() - 1]) < n) {
            queue.poll();
        }
        if (queue.isEmpty()) {
            return -1;
        }
        int idx = queue.peek();
        if (count == n) {
            queue.poll();
        }
        A[idx - 1] = count - n;
        return A[idx];
    }
}

class RLEIterator2 {

    private int[] A;
    private int i, q;
    public RLEIterator2(int[] A) {
        this.A = A;
        i = q = 0;
    }

    public int next(int n) {
        while (i < A.length) {
            if (q + n > A[i]) {
                n -= A[i] - q;
                q = 0;
                i += 2;
            } else {
                q += n;
                return A[i + 1];
            }
        }
        return -1;
    }
}