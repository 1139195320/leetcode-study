package com.jack.algorithm.problem.midium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jack
 */
public class LeetCode1461 {

    public boolean hasAllCodes(String s, int k) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i <= s.length() - k; i++) {
            set.add(s.substring(i, i + k));
        }
        return set.size() == Math.pow(2, k);
    }
}
