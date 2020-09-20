package com.jack.algorithm.problem.hard;

/**
 * @author jack
 */
public class LeetCode0044 {

    public boolean isMatch(String s, String p) {
        // '?' 可以匹配任何单个字符。
        // '*' 可以匹配任意字符串（包括空字符串）。
        // 两个字符串完全匹配才算匹配成功。
        int sLen = s.length();
        int pLen = p.length();
        int i = 0, j = 0;
        int start = -1, tmp = -1;
        while (i < sLen) {
            if (j < pLen && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
                i ++;
                j ++;
            }
            else if (j < pLen && p.charAt(j) == '*') {
                start = j;
                tmp = i;
                j ++;
            }
            else if (start == -1) {
                return false;
            }
            else {
                j = start + 1;
                i = tmp + 1;
                tmp  = i;
            }
        }
        while (j < pLen) {
            if (p.charAt(j ++) != '*') {
                return false;
            }
        }
        return true;
    }

    public boolean isMatch2(String s, String p) {
        int i = 0;
        int j = 0;
        int lenS = s.length();
        int lenP = p.length();
        int cacheI = -1;
        int cacheJ = 0;
        while (i < s.length()) {
            if (j < lenP && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i ++;
                j ++;
            }
            else if (j < lenP && p.charAt(j) == '*') {
                // 先用 * 匹配 0 个字符
                cacheI = i;
                cacheJ = j;
                j ++;
            }
            else if (cacheI != -1) {
                // 此处不匹配，但前面有 * 号，回退
                // * 匹配数增加然后继续
                i = cacheI + 1;
                j = cacheJ + 1;
                cacheI = i;
            }
            else {
                return false;
            }
        }
        while (j < lenP) {
            if (p.charAt(j ++) != '*') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode0044 main = new LeetCode0044();
        System.out.println(main.isMatch("aa", "a"));
        System.out.println(main.isMatch("aa", "*"));
        System.out.println(main.isMatch("cb", "?a"));
        System.out.println(main.isMatch("adceb", "*a*b"));
        System.out.println(main.isMatch("acdcb", "a*c?b"));
        System.out.println(main.isMatch("a", "a*"));
    }
}