package com.jack.algorithm.problem.midium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author jack
 */
public class LeetCode1297 {

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int res = 0;
        int n = s.length();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < (n - minSize + 1); i++) {
            String cur = s.substring(i, i + minSize);
            Set<Character> set = new HashSet<>();
            byte flag = 0;
            for (char c : cur.toCharArray()) {
                set.add(c);
                if (set.size() > maxLetters) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                map.put(cur, map.getOrDefault(cur, 0) + 1);
                res = Math.max(res, map.get(cur));
            }
        }
        return res;
    }
}
