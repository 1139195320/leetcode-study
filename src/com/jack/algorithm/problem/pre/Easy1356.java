package com.jack.algorithm.problem.pre;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author jack
 */
public class Easy1356 {

    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return arr;
        }
        Map<Integer, List<Integer>> map = new HashMap<>(arr.length);
        for (int data : arr) {
            // 可替换： Integer.bitCount(data);
            String str = Integer.toBinaryString(data);
            int count = count1(str);
            List<Integer> list = map.computeIfAbsent(count,
                    k -> new ArrayList<>());
            list.add(data);
        }
        int[] res = new int[arr.length];
        int i = 0;
        List<List<Integer>> dataList = map.entrySet()
                .stream()
                .sorted(Comparator.comparingInt(Map.Entry::getKey))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
        for (List<Integer> list : dataList) {
            Collections.sort(list);
            for (int data : list) {
                res[i ++] = data;
            }
        }
        return res;
    }
    private int count1(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                count ++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Easy1356 main = new Easy1356();
        System.out.println(Arrays.toString(main.sortByBits(
                new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8}
        )));
        System.out.println(Arrays.toString(main.sortByBits(
                new int[]{1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1}
        )));
        System.out.println(Arrays.toString(main.sortByBits(
                new int[]{10, 100, 1000, 10000}
        )));
    }
}