package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Medium1400 {

    public boolean canConstruct(String s, int k) {
        int n = s.length();
        if (n == k) {
            // 独行侠
            return true;
        }
        if (n < k) {
            // 没有足够的字符
            return false;
        }
        int[] arr = new int[26];
        char[] cs = s.toCharArray();
        for (char c : cs) {
            arr[c - 'a'] ++;
        }
        // 偶数部分可拆可合，可忽略
        // 数量奇数的个数
        int count1 = 0;
        for (int i : arr) {
            if ((i & 1) != 0) {
                count1 ++;
            }
        }
        return count1 <= k;
    }

    public static void main(String[] args) {
        Medium1400 main = new Medium1400();
        System.out.println(main.canConstruct(
                "annabelle", 2
        ));
        System.out.println(main.canConstruct(
                "leetcode", 3
        ));
        System.out.println(main.canConstruct(
                "true", 4
        ));
        System.out.println(main.canConstruct(
                "yzyzyzyzyzyzyzy", 2
        ));
    }
}