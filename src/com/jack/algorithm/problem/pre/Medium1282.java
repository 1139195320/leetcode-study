package com.jack.algorithm.problem.pre;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author jack
 */
public class Medium1282 {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList<>();
        int n = groupSizes.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = groupSizes[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, Comparator.comparing(a -> a[0]));
        int count;
        for (int i = 0; i < n; i += count) {
            count = arr[i][0];
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < count; j++) {
                list.add(arr[i + j][1]);
            }
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        Medium1282 main = new Medium1282();
        System.out.println(main.groupThePeople(
                new int[]{3, 3, 3, 3, 3, 1, 3}
        ));
        System.out.println(main.groupThePeople(
                new int[]{2, 1, 3, 3, 3, 2}
        ));
    }
}