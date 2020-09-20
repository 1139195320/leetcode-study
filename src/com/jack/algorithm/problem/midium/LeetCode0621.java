package com.jack.algorithm.problem.midium;

import java.util.Arrays;

/**
 * @author jack
 */
public class LeetCode0621 {

    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char task : tasks) {
            map[task - 'A'] ++;
        }
        Arrays.sort(map);
        int res = 0;
        while (map[25] > 0) {
            int i = 0;
            while (i <= n) {
                if (map[25] == 0) {
                    break;
                }
                if (i <= 25 && map[25 - i] > 0) {
                    map[25 - i] --;
                }
                res ++;
                i ++;
            }
            Arrays.sort(map);
        }
        return res;
    }

    public int leastInterval2(char[] tasks, int n) {
        int[] map = new int[26];
        for (char task : tasks) {
            map[task - 'A']++;
        }
        Arrays.sort(map);
        int curMax = map[25] - 1;
        // 等待冷却的时间
        int times = curMax * n;
        for (int i = 24; i >= 0; i--) {
            int cur = map[i];
            if (cur == 0) {
                break;
            }
            times -= Math.min(cur, curMax);
        }
        return times > 0 ? times + tasks.length : tasks.length;
    }

    public static void main(String[] args) {
        LeetCode0621 main = new LeetCode0621();
        System.out.println(main.leastInterval(
                new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2
        ));
        System.out.println(main.leastInterval2(
                new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2
        ));
    }
}