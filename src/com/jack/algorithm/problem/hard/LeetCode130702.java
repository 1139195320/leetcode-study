package com.jack.algorithm.problem.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 反向，从低位到高位依次匹配，一位一位依次往左，ok
 * @author jack
 */
public class LeetCode130702 {

    private boolean[] visited;
    private Map<Character, Integer> map;
    private boolean res;
    private int max = 9;
    private int maxLen;
    private List<Character> noZeroList;
    public boolean isSolvable(String[] words, String result) {
        visited = new boolean[max + 1];
        map = new HashMap<>(max + 1);
        maxLen = 0;
        noZeroList = new ArrayList<>();
        for (String word : words) {
            maxLen = Math.max(maxLen, word.length());
            if (maxLen > result.length()) {
                return false;
            }
            if (word.length() > 1 && !noZeroList.contains(word.charAt(0))) {
                noZeroList.add(word.charAt(0));
            }
        }
        if (maxLen + 1 < result.length()) {
            return false;
        }
        res = false;
        dfs(words, 0,1, result, 0);
        return res;
    }
    private void dfs(String[] words, int wordId, int pos, String result, int preSum) {
        if (res) {
            return;
        }
        if (wordId < words.length) {
            // 该 pos 位还未翻译完，继续翻译
            String word = words[wordId];
            int i = word.length() - pos;
            if (i >= 0) {
                char c = word.charAt(i);
                if (map.containsKey(c)) {
                    dfs(words, wordId + 1, pos,
                            result, preSum + map.get(c));
                } else {
                    int start = 0;
                    if (noZeroList.contains(c)) {
                        start = 1;
                    }
                    for (int j = start; j <= max; j++) {
                        if (visited[j]) {
                            continue;
                        }
                        visited[j] = true;
                        map.put(c, j);
                        dfs(words, wordId + 1, pos,
                                result, preSum + j);
                        map.remove(c);
                        visited[j] = false;
                    }
                }
            } else {
                // 该单词已翻译完，跳过
                dfs(words, wordId + 1, pos,
                        result, preSum);
            }
        } else {
            // 该 pos 位已翻译完，开始比较
            int i = result.length() - pos;
            char c = result.charAt(i);
            if (map.containsKey(c)) {
                if (map.get(c) == preSum % 10) {
                    if (pos >= maxLen) {
                        // words 已经全部翻译完，最终的比较
                        if (pos == result.length()) {
                            // 此时 result 也已翻译完
                            res = true;
                            return;
                        }
                        dfs(words, wordId, pos + 1, result, preSum / 10);
                    }
                    else {
                        dfs(words, 0, pos + 1,
                                result, preSum / 10);
                    }
                }
            } else {
                int start = 0;
                if (noZeroList.contains(c)) {
                    start = 1;
                }
                for (int j = start; j <= max; j++) {
                    if (visited[j]) {
                        continue;
                    }
                    if (j == preSum % 10) {
                        if (pos >= maxLen) {
                            // words 已经全部翻译完，最终的比较
                            if (pos == result.length()) {
                                // 此时 result 也已翻译完
                                res = true;
                                return;
                            }
                            map.put(c, j);
                            visited[j] = true;
                            dfs(words, wordId, pos + 1, result, preSum / 10);
                        }
                        else {
                            map.put(c, j);
                            visited[j] = true;
                            dfs(words, 0, pos + 1,
                                    result, preSum / 10);
                        }
                        map.remove(c);
                        visited[j] = false;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        LeetCode130702 main = new LeetCode130702();
        System.out.println(main.isSolvable(
                new String[]{"SATURN", "URANUS"}, "PLANETS"));
        System.out.println(main.isSolvable(
                new String[]{"AB", "CD", "EF"}, "GHIJ"));
        System.out.println(main.isSolvable(
                new String[]{"a", "b"}, "a"));
        System.out.println(main.isSolvable(
                new String[]{"SEND", "MORE"}, "MONEY"));
        System.out.println(main.isSolvable(
                new String[]{"SIX","SEVEN","SEVEN"}, "TWENTY"));
        System.out.println(main.isSolvable(
                new String[]{"LEET","CODE"}, "POINT"));
    }
}