package com.jack.algorithm.problem.pre;

import java.util.TreeMap;

/**
 * @author jack
 */
public class Medium0826 {

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int res = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < difficulty.length; i++) {
            map.put(difficulty[i], profit[i]);
        }
        for (int i : worker) {
            Integer key = map.floorKey(i);
            if (key != null) {
                res += map.get(key);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Medium0826 main = new Medium0826();
        System.out.println(main.maxProfitAssignment(
                new int[]{2, 4, 6, 8, 10},
                new int[]{10, 20, 30, 40, 50},
                new int[]{1, 4, 5, 6, 7}
        ));
    }
}
