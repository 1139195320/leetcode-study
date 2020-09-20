package com.jack.algorithm.problem.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jack
 */
public class LeetCode0217 {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode0217 main = new LeetCode0217();
    }
}