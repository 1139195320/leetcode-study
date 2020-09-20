package com.jack.algorithm.problem.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jack
 */
public class LeetCode0387 {

    public int firstUniqChar(String s) {
        Set<Character> set = new HashSet<>();
        List<Character> list = new ArrayList<>();
        for (Character c : s.toCharArray()) {
            if (set.contains(c)) {
                list.remove(c);
            } else {
                list.add(c);
            }
            set.add(c);
        }
        return list.size() > 0 ? s.indexOf(list.get(0)) : -1;
    }

    public static void main(String[] args) {
        LeetCode0387 main = new LeetCode0387();
        System.out.println(main.firstUniqChar("leetcode"));
        System.out.println(main.firstUniqChar("loveleetcode"));
    }
}