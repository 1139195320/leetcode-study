package com.jack.algorithm.problem.pre;

import java.util.*;

/**
 * @author jack
 */
public class Easy1122 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>(arr2.length);
        Set<Integer> set = new TreeSet<>();
        for (int data : arr1) {
            map.put(data, map.getOrDefault(data, 0) + 1);
            set.add(data);
        }
        int[] res = new int[arr1.length];
        int i = 0;
        for (int data : arr2) {
            for (int j = 0; j < map.get(data); j++) {
                res[i ++] = data;
            }
            set.remove(data);
        }
        for (int data : set) {
            for (int j = 0; j < map.get(data); j++) {
                res[i ++] = data;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Easy1122 main = new Easy1122();
        System.out.println(Arrays.toString(main.relativeSortArray(
                new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19},
                new int[]{2, 1, 4, 3, 9, 6}
        )));
    }
}