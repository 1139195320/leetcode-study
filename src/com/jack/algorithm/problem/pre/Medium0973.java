package com.jack.algorithm.problem.pre;

import java.util.*;

/**
 * @author jack
 */
public class Medium0973 {

    public int[][] kClosest(int[][] points, int K) {
        int n = points.length;
        map = new HashMap<>(n);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            map.put(i, point[0] * point[0] + point[1] * point[1]);
            addData(list, i);
        }
        int[][] res = new int[K][2];
        for (int i = 0; i < K; i++) {
            res[i] = points[list.get(i)];
        }
        return res;
    }
    private Map<Integer, Integer> map;
    private void addData(List<Integer> list, int data) {
        if (list.size() == 0) {
            list.add(data);
            return;
        }
        int size = list.size();
        int product = map.get(data);
        if (map.get(list.get(size - 1)) <= product) {
            list.add(data);
            return;
        }
        if (map.get(list.get(0)) >= product) {
            list.add(0, data);
            return;
        }
        int l = 0, r = size - 1;
        int idx = 0;
        while (l < r) {
            int m = (l + r) >> 1;
            int c = map.get(m);
            if (l == m || c == product) {
                idx = m + 1;
                break;
            } else if (c < product) {
                l = m;
            } else {
                r = m;
            }
        }
        list.add(idx, data);
    }

    public static void main(String[] args) {
        Medium0973 main = new Medium0973();
        System.out.println(Arrays.deepToString(main.kClosest(
                new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2
        )));
        System.out.println(Arrays.deepToString(main.kClosest(
                new int[][]{{1, 3}, {-2, 2}}, 1
        )));
    }
}