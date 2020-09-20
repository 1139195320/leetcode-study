package com.jack.algorithm.problem.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author jack
 */
public class LeetCode1046 {

    public int lastStoneWeight(int[] stones) {
        List<Integer> list = new ArrayList<>();
        for (int stone : stones) {
            list.add(stone);
        }
        int n = list.size();
        while (n > 1) {
            Collections.sort(list);
            int xIndex = list.size() - 2;
            int yIndex = list.size() - 1;
            int x = list.get(xIndex);
            int y = list.get(yIndex);
            list.remove(xIndex);
            list.remove(xIndex);
            n --;
            if (x == y) {
                n --;
            } else {
                list.add(y - x);
            }
        }
        return list.size() == 1 ? list.get(0) : 0;
    }

    public int lastStoneWeight2(int[] stones) {
        int n = stones.length;
        PriorityQueue<Integer> queue =
                new PriorityQueue<>(n, (a, b) -> b - a);
        for (int stone : stones) {
            queue.add(stone);
        }
        while (queue.size() > 1) {
            int y = queue.poll();
            int x = queue.poll();
            queue.offer(y - x);
        }
        return queue.poll();
    }

    public static void main(String[] args) {
        LeetCode1046 main = new LeetCode1046();
        System.out.println(main.lastStoneWeight(
                new int[]{2, 7, 4, 1, 8, 1}
        ));
    }
}