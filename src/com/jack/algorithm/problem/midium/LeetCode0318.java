package com.jack.algorithm.problem.midium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jack
 */
public class LeetCode0318 {

    public int maxProduct(String[] words) {
        Map<Integer, Integer> map = new HashMap<>();
        for (String word : words) {
            int tmp = 0;
            for (char c : word.toCharArray()) {
                tmp |= (1 << (c - 'a'));
            }
            map.put(tmp, Math.max(word.length(),
                    map.getOrDefault(tmp, 0)));
        }
        if (map.size() < 2) {
            return 0;
        }
        int res = 0;
        for (int key1 : map.keySet()) {
            for (int key2 : map.keySet()) {
                if ((key1 & key2) == 0) {
                    // 不含有公共字母
                    res = Math.max(res, map.get(key1) * map.get(key2));
                }
            }
        }
        return res;
    }
}
