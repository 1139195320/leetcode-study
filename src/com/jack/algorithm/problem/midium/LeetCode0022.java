package com.jack.algorithm.problem.midium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jack
 */
public class LeetCode0022 {

    private List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        doGenerateParenthesis(n, 1, 0, "(");
        return res;
    }

    /**
     * @param n 括号数
     * @param a 已放置左括号数
     * @param b 已放置右括号数
     * @param str 当前字符串
     */
    private void doGenerateParenthesis(int n, int a, int b, String str) {
        if (a == n && b == n) {
            // ending
            res.add(str);
            return;
        }
        if (a < n) {
            doGenerateParenthesis(n, a + 1, b, str + "(");
        }
        if (a > b) {
            doGenerateParenthesis(n, a, b + 1, str + ")");
        }
    }

    public static void main(String[] args) {
        LeetCode0022 main = new LeetCode0022();
        System.out.println(main.generateParenthesis(3));
    }
}