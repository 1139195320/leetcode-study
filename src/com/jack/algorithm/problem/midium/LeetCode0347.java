package com.jack.algorithm.problem.midium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author jack
 */
public class LeetCode0347 {

    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) {
            return new int[]{};
        }
        int[] res = new int[k];
        Map<Integer, Integer> map = new HashMap<>(k);
        for (int cur : nums) {
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }
        Integer[] tmp = new Integer[map.size()];
        int idx = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            tmp[idx ++] = entry.getKey();
        }
        Arrays.sort(tmp, (a, b) -> map.get(b) - map.get(a));
        for (int i = 0; i < k; i++) {
            res[i] = tmp[i];
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0347 main = new LeetCode0347();
        System.out.println(Arrays.toString(main.topKFrequent(
                new int[]{4, 1, -1, 2, -1, 2, 3}, 2
        )));
    }
}
