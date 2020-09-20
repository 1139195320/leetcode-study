package com.jack.algorithm.problem.pre;

import java.util.*;

/**
 * @author jack
 */
public class Medium1054 {

    private Map<Integer, Integer> map;
    public int[] rearrangeBarcodes(int[] barcodes) {
        int n = barcodes.length;
        map = new HashMap<>(n);
        // 存放数和其对应的数量
        for (int barcode : barcodes) {
            map.put(barcode, map.getOrDefault(barcode, 0) + 1);
        }
        // 存放根据数量排的序，从大到小
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            addData(list, entry.getKey());
        }
        int[] res = new int[n];
        // 先填充奇数位
        int i = 0;
        int j = 0;
        while (i < n) {
            int cur = list.get(j);
            res[i] = cur;
            int count = map.get(cur) - 1;
            if (count == 0) {
                j ++;
            } else {
                map.put(cur, count);
            }
            i += 2;
        }
        // 再填充偶数位
        i = 1;
        while (i < n) {
            int cur = list.get(j);
            res[i] = cur;
            int count = map.get(cur) - 1;
            if (count == 0) {
                j ++;
            } else {
                map.put(cur, count);
            }
            i += 2;
        }
        return res;
    }
    private void addData(List<Integer> list, int data) {
        if (list.size() == 0) {
            list.add(data);
            return;
        }
        int size = list.size();
        int count = map.get(data);
        if (map.get(list.get(size - 1)) >= count) {
            list.add(data);
            return;
        }
        if (map.get(list.get(0)) <= count) {
            list.add(0, data);
            return;
        }
        int l = 0, r = size - 1;
        int idx = 0;
        while (l < r) {
            int m = (l + r) >> 1;
            int c = map.get(m);
            if (l == m || c == count) {
                idx = m + 1;
                break;
            } else if (c > count) {
                l = m;
            } else {
                r = m;
            }
        }
        list.add(idx, data);
    }

    public static void main(String[] args) {
        Medium1054 main = new Medium1054();
        System.out.println(Arrays.toString(main.rearrangeBarcodes(
                new int[]{1, 1, 1, 2, 2, 2, 1}
        )));
        System.out.println(Arrays.toString(main.rearrangeBarcodes(
                new int[]{1, 1, 1, 1, 2, 2, 3, 3}
        )));
    }
}