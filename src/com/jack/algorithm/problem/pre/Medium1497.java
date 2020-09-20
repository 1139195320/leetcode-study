package com.jack.algorithm.problem.pre;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jack
 */
public class Medium1497 {

    public boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>(k);
        for (int cur : arr) {
            int mod = cur % k;
            if (mod < 0) {
                // 将模变正
                mod += k;
            }
            if (mod != 0) {
                map.put(mod, map.getOrDefault(mod, 0) + 1);
            }
        }
        int end = (k >> 1) + 1;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            if (key >= end) {
                break;
            }
            if (!map.getOrDefault(k - key, 0)
                    .equals(entry.getValue())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Medium1497 main = new Medium1497();
        System.out.println(main.canArrange(
                new int[]{1, 2, 3, 4, 5, 10, 6, 7, 8, 9}, 5
        ));
        System.out.println(main.canArrange(
                new int[]{1, 2, 3, 4, 5, 6}, 7
        ));
        System.out.println(main.canArrange(
                new int[]{1, 2, 3, 4, 5, 6}, 10
        ));
        System.out.println(main.canArrange(
                new int[]{-10, 10}, 2
        ));
        System.out.println(main.canArrange(
                new int[]{-1, 1, -2, 2, -3, 3, -4, 4}, 3
        ));
    }
}