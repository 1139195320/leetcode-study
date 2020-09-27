package com.jack.algorithm.problem.still;

import java.util.*;

/**
 * @author jack
 * 官方题解
 * hard
 */
public class LeetCode0140 {

    private Map<Integer, List<String>> map;
    public List<String> wordBreak(String s, List<String> wordDict) {
        map = new HashMap<>();
        return dfs(s, 0, wordDict);
    }
    private List<String> dfs(String s, int start, List<String> wordDict) {
        if (map.containsKey(start)) {
            return map.get(start);
        }
        LinkedList<String> res = new LinkedList<>();
        if (start == s.length()) {
            res.add("");
        }
        for (int end = start + 1; end <= s.length(); end++) {
            String cur = s.substring(start, end);
            if (wordDict.contains(cur)) {
                List<String> list = dfs(s, end, wordDict);
                for (String data : list) {
                    res.add(s.substring(start, end)
                            + ("".equals(data) ? "" : " ") + data);
                }
            }
        }
        map.put(start, res);
        return res;
    }

    public static void main(String[] args) {
        LeetCode0140 main = new LeetCode0140();
        System.out.println(main.wordBreak("catsanddog",
                Arrays.asList("cat", "cats", "and", "sand", "dog")));
        System.out.println(main.wordBreak("pineapplepenapple",
                Arrays.asList("apple", "pen", "applepen", "pine", "pineapple")));
        System.out.println(main.wordBreak("catsandog",
                Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }
}