package com.jack.algorithm.problem.pre;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jack
 */
public class Medium1387 {

    private Map<Integer, Integer> cache;
    public int getKth(int lo, int hi, int k) {
        int n = hi - lo;
        cache = new HashMap<>(n);
        Integer[] arr = new Integer[n + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + lo;
        }
        Arrays.sort(arr, Comparator.comparingInt(this::getCount));
        return arr[k - 1];
    }
    private int getCount(int t) {
        if (t == 1) {
            return 0;
        }
        if (cache.containsKey(t)) {
            return cache.get(t);
        }
        int count;
        if (t % 2 == 0) {
            count = getCount(t >> 1) + 1;
        } else {
            count = getCount(t * 3 + 1) + 1;
        }
        cache.put(t, count);
        return count;
    }

    public static void main(String[] args) {
        Medium1387 main = new Medium1387();
        System.out.println(main.getKth(12, 15, 2));
        System.out.println(main.getKth(1, 1, 1));
        System.out.println(main.getKth(7, 11, 4));
        System.out.println(main.getKth(10, 20, 5));
        System.out.println(main.getKth(1, 1000, 777));
    }
}