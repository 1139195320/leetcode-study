package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0389 {

    public char findTheDifference(String s, String t) {
        int tmp = 0;
        for (char c : s.toCharArray()) {
            tmp ^= (c - 'a');
        }
        for (char c : t.toCharArray()) {
            tmp ^= (c - 'a');
        }
        return (char) (tmp + 'a');
    }
}
