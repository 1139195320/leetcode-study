package com.jack.algorithm.problem.pre;

import java.util.*;

/**
 * @author jack
 */
public class Medium11002 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String tmp = String.valueOf(arr);
            List<String> list = map.computeIfAbsent(tmp, k -> new ArrayList<>());
            list.add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Medium11002 main = new Medium11002();
        System.out.println(main.groupAnagrams(
                new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}
        ));
    }
}