package com.jack.algorithm.problem.pre;

import java.util.Arrays;

/**
 * @author jack
 */
public class Medium1094 {

    public boolean carPooling(int[][] trips, int capacity) {
        // trips[i]：人数、起点、终点
        Arrays.sort(trips, (a, b) -> {
            if (a[1] == b[1]) {
                return a[2] - b[2];
            }
            return a[1] - b[1];
        });
        // 记录某站点实际需要载数
        int[] total = new int[1001];
        for (int[] trip : trips) {
            for (int j = trip[1]; j < trip[2]; j++) {
                total[j] += trip[0];
                // 判断载数是否大于容量
                if (total[j] > capacity) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean carPooling2(int[][] trips, int capacity) {
        // trips[i]：人数、起点、终点
        Arrays.sort(trips, (a, b) -> {
            if (a[1] == b[1]) {
                return a[2] - b[2];
            }
            return a[1] - b[1];
        });
        // 记录某站点变化数
        int[] allChanges = new int[1001];
        for (int[] trip : trips) {
            allChanges[trip[1]] += trip[0];
            allChanges[trip[2]] -= trip[0];
        }
        for (int curChange : allChanges) {
            capacity -= curChange;
            if (capacity < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Medium1094 main = new Medium1094();
        System.out.println(main.carPooling(
                new int[][] {
                        {2, 1, 5},
                        {3, 3, 7}
                }, 5
        ));
        System.out.println(main.carPooling(
                new int[][] {
                        {2, 1, 5},
                        {3, 3, 7}
                }, 3
        ));
        System.out.println(main.carPooling2(
                new int[][] {
                        {2, 1, 5},
                        {3, 3, 7}
                }, 5
        ));
        System.out.println(main.carPooling2(
                new int[][] {
                        {2, 1, 5},
                        {3, 3, 7}
                }, 3
        ));
    }
}