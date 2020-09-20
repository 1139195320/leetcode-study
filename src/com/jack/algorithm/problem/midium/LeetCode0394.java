package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0394 {

    public String decodeString(String target) {
        StringBuilder sb = new StringBuilder();
        char start = '[';
        char end = ']';
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            int n = 0;
            if (Character.isDigit(c)) {
                // 数字开始
                while (Character.isDigit(c)) {
                    n = n * 10 + c - '0';
                    i ++;
                    c = target.charAt(i);
                }
                // 此时 i 处是 '['
                StringBuilder tmp = new StringBuilder();
                i ++;
                c = target.charAt(i);
                // 记录 '[' 的个数
                int k = 1;
                while (k != 0) {
                    tmp.append(c);
                    i ++;
                    c = target.charAt(i);
                    if (end == c) {
                        k --;
                    }
                    if (start == c) {
                        k ++;
                    }
                }
                // 此时 i 处是 ']'，且 ']' 的个数与 '[' 相匹配
                sb.append(getStr(decodeString(tmp.toString()), n));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
    private String getStr(String str, int n) {
        StringBuilder sb = new StringBuilder(str.length() * n);
        for (int i = 0; i < n; i++) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode0394 main = new LeetCode0394();
        System.out.println(main.decodeString("3[a2[c]]"));
        System.out.println(main.decodeString("abc2[a]"));
        System.out.println(main.decodeString("abc2[a]10[bc]"));
        System.out.println(main.decodeString("2[a]5[bc]def"));
    }
}