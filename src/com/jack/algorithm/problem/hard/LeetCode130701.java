package com.jack.algorithm.problem.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 正向，从高位到低位，然后一起匹配，超时
 * @author jack
 */
public class LeetCode130701 {

    private boolean[] visited;
    private List<Character> list;
    private List<Character> noZeroList;
    private Map<Character, Integer> map;
    private boolean res;
    private int max = 9;
    public boolean isSolvable(String[] words, String result) {
        visited = new boolean[max + 1];
        map = new HashMap<>(max + 1);
        list = new ArrayList<>();
        noZeroList = new ArrayList<>();
        int resultLen = result.length();
        for (String word : words) {
            if (word.length() > resultLen) {
                return false;
            }
            if (word.length() > 1 && !noZeroList.contains(word.charAt(0))) {
                noZeroList.add(word.charAt(0));
            }
            for (char c : word.toCharArray()) {
                if (!list.contains(c)) {
                    list.add(c);
                }
            }
        }
        if (result.length() > 1 && !noZeroList.contains(result.charAt(0))) {
            noZeroList.add(result.charAt(0));
        }
        for (char c : result.toCharArray()) {
            if (!list.contains(c)) {
                list.add(c);
            }
        }
        res = false;
        dfs(words, result, 0);
        return res;
    }
    private boolean check(String[] words, String result) {
        int sum1 = 0;
        for (String word : words) {
            int curSum = 0;
            for (char c : word.toCharArray()) {
                curSum = curSum * 10 + map.get(c);
            }
            sum1 += curSum;
        }
        int sum2 = 0;
        for (char c : result.toCharArray()) {
            sum2 = sum2 * 10 + map.get(c);
        }
        return sum1 == sum2;
    }
    private void dfs(String[] words, String result, int start) {
        if (map.size() == list.size()) {
            if (check(words, result)) {
                res = true;
            }
            return;
        }
        for (int i = start; i < list.size() && !res; i++) {
            char c = list.get(i);
            for (int j = 0; j <= max; j++) {
                if (j == 0 && noZeroList.contains(c)) {
                    continue;
                }
                if (visited[j]) {
                    continue;
                }
                map.put(c, j);
                visited[j] = true;
                dfs(words, result, i + 1);
                if (res) {
                    break;
                }
                map.remove(c);
                visited[j] = false;
            }
        }
    }

    public static void main(String[] args) {
        LeetCode130701 main = new LeetCode130701();
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