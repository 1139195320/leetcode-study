package com.jack.algorithm.problem.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jack
 */
public class LeetCode0784 {

    private List<String> res;
    public List<String> letterCasePermutation(String S) {
        res = new ArrayList<>();
        dfs(S, "", 0);
        return res;
    }
    private void dfs(String S, String curStr, int start) {
        StringBuilder sb = new StringBuilder(curStr);
        for (int i = start; i < S.length(); i++) {
            char cur = S.charAt(i);
            if (cur >= 'a' && cur <= 'z') {
                dfs(S, sb.toString() + (char) (cur - 32), i + 1);
            } else if (cur >= 'A' && cur <= 'Z') {
                dfs(S, sb.toString() + (char) (cur + 32), i + 1);
            }
            sb.append(cur);
        }
        res.add(sb.toString());
    }

    public static void main(String[] args) {
        LeetCode0784 main = new LeetCode0784();
        System.out.println(main.letterCasePermutation("a1b2"));
        System.out.println(main.letterCasePermutation("3z4"));
        System.out.println(main.letterCasePermutation("12345"));
    }
}