package com.jack.algorithm.problem.pre;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jack
 */
public class Medium0406 {

    public int[][] reconstructQueue(int[][] people) {
        // 前面是高度，后面是人数
        int n = people.length;
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
                // 高度相同，人数递增
                return a[1] - b[1];
            }
            // 高度递减
            return b[0] - a[0];
        });
        List<int[]> list = new LinkedList<>();
        for (int[] person : people) {
            list.add(person[1], person);
        }
        return list.toArray(new int[n][2]);
    }

    public static void main(String[] args) {
        Medium0406 main = new Medium0406();
        System.out.println(Arrays.deepToString(main.reconstructQueue(
                new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}}
        )));
    }
}