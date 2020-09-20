package com.jack.algorithm.problem.midium;

import java.util.*;

/**
 * @author jack
 */
public class LeetCode1353 {

    public int maxEvents(int[][] events) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[1]));
        Set<Integer> set = new HashSet<>();
        for (int[] event : events) {
            int start = event[0];
            int end = event[1];
            for (int i = start; i <= end; i++) {
                if (!set.contains(i)) {
                    set.add(i);
                    break;
                }
            }
        }
        return set.size();
    }

    public int maxEvents2(int[][] events) {
        Arrays.sort(events, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int res = 0;
        int start = 1;
        int i = 0;
        int n = events.length;
        while (i < n || !pq.isEmpty()) {
            // 将 start 相同的会议放进堆里
            while (i < n && events[i][0] == start) {
                pq.offer(events[i ++][1]);
            }
            // 去除当前天数之前的
            while (!pq.isEmpty() && pq.peek() < start) {
                pq.poll();
            }
            // 顶上的就是要参加的会议
            if (!pq.isEmpty()) {
                pq.poll();
                res ++;
            }
            start ++;
        }
        return res;
    }
}
