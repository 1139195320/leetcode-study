package com.jack.algorithm.problem.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jack
 */
public class LeetCode0459 {

    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        if (n < 2) {
            return false;
        }
        List<Integer> list = getFactor(n);
        // 重复的子串的长度
        for (int factor : list) {
            // 重复的串
            char[] repeatedArr = s.substring(0, factor)
                    .toCharArray();
            // 应该分成多少串
            int strSize = n / factor;
            boolean flag = true;
            for (int i = 0; i < factor && flag; i++) {
                for (int j = 1; j < strSize; j++) {
                    if (s.charAt(factor * j + i) != repeatedArr[i]) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }
    private List<Integer> getFactor(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = n >> 1; i > 1; i--) {
            if (n % i == 0) {
                boolean has = false;
                for (int visitedI : list) {
                    if (visitedI % i == 0) {
                        // visitedI 和 i 都是因数的情况下
                        // 如果 i 可重复，则 visitedI 必可以重复
                        // 如果 visitedI 重复，i 不一定重复
                        // 如果 visitedI 不重复，i 必不可以重复
                        has = true;
                        break;
                    }
                }
                if (!has) {
                    list.add(i);
                }
            }
        }
        list.add(1);
        return list;
    }

    public boolean repeatedSubstringPattern2(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }

    public static void main(String[] args) {
        LeetCode0459 main = new LeetCode0459();
        System.out.println(main.repeatedSubstringPattern("abab"));
        System.out.println(main.repeatedSubstringPattern("abcdabcd"));
        System.out.println(main.repeatedSubstringPattern("abcde"));
        System.out.println(main.repeatedSubstringPattern("aaaaa"));
    }
}