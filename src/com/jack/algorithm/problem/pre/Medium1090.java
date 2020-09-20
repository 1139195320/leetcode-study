package com.jack.algorithm.problem.pre;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jack
 */
public class Medium1090 {

    public int largestValsFromLabels(int[] values, int[] labels,
                                     int num_wanted, int use_limit) {
        // 子集元素数量不大于 num_wanted
        // 子集对应的 label 最大相同 use_limit 个
        int n = values.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = values[i];
            arr[i][1] = labels[i];
        }
        Arrays.sort(arr, Comparator.comparing(a -> a[0]));
        Map<Integer, Integer> map = new HashMap<>(num_wanted);
        int res = 0;
        for (int i = n - 1; i >= 0 && num_wanted > 0; i--) {
            int curLabel = arr[i][1];
            if (!map.containsKey(curLabel) || map.get(curLabel) < use_limit) {
                res += arr[i][0];
                map.put(curLabel, map.getOrDefault(curLabel, 0) + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Medium1090 main = new Medium1090();
        System.out.println(main.largestValsFromLabels(
                new int[] {5, 4, 3, 2, 1},
                new int[] {1, 1, 2, 2, 3},
                3, 1
        ));
    }
}