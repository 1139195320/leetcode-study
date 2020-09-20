package com.jack.algorithm.problem.midium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jack
 */
public class LeetCode0974 {

    /**
     * 前缀和 求解
     */
    public int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>(A.length);
        map.put(0, 1);
        int sum = 0;
        int res = 0;
        for (int a : A) {
            sum += a;
            // 针对负数需特殊处理
            int mod = (sum % K + K) % K;
            int same = map.getOrDefault(mod, 0);
            res += same;
            map.put(mod, same + 1);
        }
        return res;
    }

    public int subarraysDivByK2(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>(A.length);
        map.put(0, 1);
        int sum = 0;
        for (int a : A) {
            sum += a;
            // 针对负数需特殊处理
            int mod = (sum % K + K) % K;
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            res += entry.getValue() * (entry.getValue() + 1) / 2;
        }
        return res;
    }
}
