package com.jack.algorithm.problem.midium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jack
 */
public class LeetCode0187 {

    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        Set<String> seen = new HashSet<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n - 9; i++) {
            String cur = s.substring(i, i + 10);
            if (seen.contains(cur)) {
                set.add(cur);
            }
            seen.add(cur);
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        LeetCode0187 main = new LeetCode0187();
        System.out.println(main.findRepeatedDnaSequences(
                "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
}