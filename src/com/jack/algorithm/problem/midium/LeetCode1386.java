package com.jack.algorithm.problem.midium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author jack
 */
public class LeetCode1386 {

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        // 记录每一行里面被预约了的列
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] reservedSeat : reservedSeats) {
            Set<Integer> list = map.computeIfAbsent(reservedSeat[0],
                    k -> new HashSet<>());
            list.add(reservedSeat[1]);
        }
        int res = (n - map.size()) * 2;
        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            Set<Integer> set = entry.getValue();
            int count = 0;
            boolean flag = false;
            if (!set.contains(2) && !set.contains(3)
                    && !set.contains(4) && !set.contains(5)) {
                count ++;
                flag = true;
            }
            if (!set.contains(6) && !set.contains(7)
                    && !set.contains(8) && !set.contains(9)) {
                count ++;
                flag = true;
            }
            if (!flag && !set.contains(4) && !set.contains(5)
                    && !set.contains(6) && !set.contains(7)) {
                count ++;
            }
            res += count;
        }
        return res;
    }

    public int maxNumberOfFamilies2(int n, int[][] reservedSeats) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] reservedSeat : reservedSeats) {
            int key = reservedSeat[0];
            int val = reservedSeat[1];
            if (val >= 2 && val <= 9) {
                map.put(key, map.getOrDefault(key, 0)
                        + (1 << (9 - val)));
            }
        }
        int[] arr = new int[3];
        arr[0] = 0b11110000;
        arr[1] = 0b11000011;
        arr[2] = 0b00001111;
        int res = (n - map.size()) * 2;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            for (int data : arr) {
                if ((data | entry.getValue()) == data) {
                    res ++;
                    break;
                }
            }
        }
        return res;
    }
}
