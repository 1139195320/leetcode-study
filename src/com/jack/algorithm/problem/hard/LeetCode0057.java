package com.jack.algorithm.problem.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jack
 */
public class LeetCode0057 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        if (n == 0) {
            return new int[][] {newInterval};
        }
        List<int[]> list = new ArrayList<>();
        int preStart = intervals[0][0];
        int preEnd = intervals[0][1];
        // 连接中，还未连接完
        boolean flagA = false;
        // 已连接完
        boolean flagB = false;
        for (int i = 0; i < n; i++) {
            int[] interval = intervals[i];
            if (flagB) {
                list.add(interval);
                continue;
            }
            if (flagA) {
                if (preEnd < interval[0]) {
                    flagB = true;
                    list.add(new int[]{preStart, preEnd});
                    list.add(interval);
                } else {
                    preEnd = Math.max(preEnd, interval[1]);
                    if (i == n - 1) {
                        list.add(new int[]{preStart, preEnd});
                    }
                }
            } else {
                preStart = interval[0];
                preEnd = interval[1];
                if (preStart > newInterval[1]) {
                    // c, d, a, b
                    flagA = true;
                    flagB = true;
                    list.add(newInterval);
                    list.add(new int[]{preStart, preEnd});
                } else if (preEnd >= newInterval[0]) {
                    // a, c, (b, d)
                    // c, a, d, b
                    flagA = true;
                    preStart = Math.min(preStart, newInterval[0]);
                    preEnd = Math.max(preEnd, newInterval[1]);
                    if (i == n - 1) {
                        list.add(new int[]{preStart, preEnd});
                    }
                }
                else {
                    list.add(new int[]{preStart, preEnd});
                    if (i == n - 1) {
                        list.add(newInterval);
                    }
                }
            }
        }
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0057 main = new LeetCode0057();
        System.out.println(Arrays.deepToString(main.insert(
                new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}},
                new int[]{4, 8}
        )));
        System.out.println(Arrays.deepToString(main.insert(
                new int[][]{{1, 3}, {6, 9}},
                new int[]{2, 5}
        )));
    }
}