package com.jack.algorithm.problem.pre;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author jack
 */
public class Medium1338 {

    public int minSetSize(int[] arr) {
        int target = arr.length >> 1;
        Map<Integer, Integer> map = new HashMap<>(target);
        for (int data : arr) {
            map.put(data, map.getOrDefault(data, 0) + 1);
        }
        int[] tmp = new int[map.size()];
        Iterator<Integer> iterator = map.values().iterator();
        int i = 0;
        while (iterator.hasNext()) {
            tmp[i ++] = iterator.next();
        }
        Arrays.sort(tmp);
        int res = 0;
        int sum = 0;
        for (int j = tmp.length - 1; j >= 0; j--) {
            res ++;
            sum += tmp[j];
            if (sum >= target) {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Medium1338 main = new Medium1338();
        System.out.println(main.minSetSize(
                new int[]{3, 3, 3, 3, 5, 5, 5, 2, 2, 7}
        ));
        System.out.println(main.minSetSize(
                new int[]{7, 7, 7, 7, 7, 7}
        ));
        System.out.println(main.minSetSize(
                new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
        ));
    }
}