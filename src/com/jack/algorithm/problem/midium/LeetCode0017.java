package com.jack.algorithm.problem.midium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jack
 */
public class LeetCode0017 {

    private static Map<Integer, char[]> map = new HashMap<>(9);
    static {
        map.put(2, new char[] {'a', 'b', 'c'});
        map.put(3, new char[] {'d', 'e', 'f'});
        map.put(4, new char[] {'g', 'h', 'i'});
        map.put(5, new char[] {'j', 'k', 'l'});
        map.put(6, new char[] {'m', 'n', 'o'});
        map.put(7, new char[] {'p', 'q', 'r', 's'});
        map.put(8, new char[] {'t', 'u', 'v'});
        map.put(9, new char[] {'w', 'x', 'y', 'z'});
    }
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.trim().length() == 0) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        doLetterCombinations(res, "", digits);
        return res;
    }

    private void doLetterCombinations(List<String> res, String pre, String digits) {
        int curLen = pre.length();
        if (curLen == digits.length()) {
            res.add(pre);
            return;
        }
        for (char c : map.get(digits.charAt(curLen) - '0')) {
            doLetterCombinations(res, pre + c, digits);
        }
    }

    private char[][] csArr;
    private List<String> res;
    public List<String> letterCombinations2(String digits) {
        if (digits == null || digits.trim().length() == 0) {
            return new ArrayList<>();
        }
        csArr = new char[][] {
                {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
                {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}
        };
        res = new ArrayList<>();
        dfs(digits.toCharArray(), 0, "");
        return res;
    }
    private void dfs(char[] arr, int curIdx, String pre) {
        int n = arr.length;
        if (curIdx == n) {
            res.add(pre);
            return;
        }
        char cur = arr[curIdx];
        for (char c : csArr[cur - '2']) {
            dfs(arr, curIdx + 1, pre + c);
        }
    }

    public static void main(String[] args) {
        LeetCode0017 main = new LeetCode0017();
        System.out.println(main.letterCombinations("23"));
    }
}