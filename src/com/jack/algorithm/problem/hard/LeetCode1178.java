package com.jack.algorithm.problem.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jack
 */
public class LeetCode1178 {

    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        // 压缩 word - 数量
        Map<Integer, Integer> map = new HashMap<>();
        for (String word : words) {
            int cur = 0;
            for (char c : word.toCharArray()) {
                cur |= (1 << (c - 'a'));
            }
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        for (String puzzle : puzzles) {
            int cur = 0;
            for (char c : puzzle.toCharArray()) {
                cur |= (1 << (c - 'a'));
            }
            int sum = 0;
            char first = puzzle.charAt(0);
            // 遍历 cur 的每一种形态
            for (int i = cur; i > 0; i = (i - 1) & cur) {
                // 要确保含有首字母
                if ((i & (1 << (first - 'a'))) != 0) {
                    sum += map.getOrDefault(i, 0);
                }
            }
            res.add(sum);
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode1178 main = new LeetCode1178();
        // 1, 1, 3, 2, 4, 0
        System.out.println(main.findNumOfValidWords(
                new String[]{"aaaa","asas","able","ability","actt","actor","access"},
                new String[]{"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"}
        ));
    }
}
