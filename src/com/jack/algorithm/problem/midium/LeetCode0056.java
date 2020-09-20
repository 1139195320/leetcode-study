package com.jack.algorithm.problem.midium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author fy
 */
public class LeetCode0056 {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        if (intervals.length == 0) {
            return new int[][]{};
        }
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));
        int minLeft = intervals[0][0];
        int maxRight = intervals[0][1];
        if (intervals.length == 1) {
            list.add(new int[]{minLeft, maxRight});
            return list.toArray(new int[0][]);
        }
        int i = 0;
        while (i < intervals.length) {
            minLeft = intervals[i][0];
            maxRight = intervals[i][1];
            while (i < intervals.length - 1 && intervals[i + 1][0] <= maxRight) {
                i ++;
                maxRight = Math.max(maxRight, intervals[i][1]);
            }
            list.add(new int[]{minLeft, maxRight});
            i ++;
        }
        return list.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        LeetCode0056 main = new LeetCode0056();
        main.testMerge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        main.testMerge(new int[][]{{1, 4}, {4, 5}});
        main.testMerge(new int[][]{{1, 9}});
        main.testMerge(new int[][]{{1, 5}, {1, 5}});
        main.testMerge(new int[][]{{1, 5}, {1, 5}, {1, 6}});
        main.testMerge(new int[][]{{1, 5}, {1, 5}, {1, 5}});
        main.testMerge(new int[][]{{1, 6}, {1, 5}, {1, 5}});
    }

    private void testMerge(int[][] intervals) {
        int[][] arrArr = merge(intervals);
        printArr(intervals);
        printArr(arrArr);
        System.out.println("===============================");
    }

    private void printArr(int[][] arrArr) {
        System.out.print("{");
        int i = 0;
        for (int[] arr : arrArr) {
            System.out.print("{" + arr[0] + ", " + arr[1] + "}");
            i ++;
            if (i != arrArr.length) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }
}
