package com.jack.algorithm.problem.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jack
 */
public class LeetCode0970 {

    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> res = new HashSet<>();
        int maxM = 20;
        for (int i = 0; i < maxM && Math.pow(x, i) <= bound; i++) {
            for (int j = 0; j < maxM && Math.pow(y, j) <= bound; j++) {
                int cur = (int) Math.pow(x, i) + (int) Math.pow(y, j);
                if (cur <= bound) {
                    res.add(cur);
                }
            }
        }
        return new ArrayList<>(res);
    }
}
