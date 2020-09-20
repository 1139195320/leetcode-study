package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0014 {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String res = strs[0];
        int len = res.length();
        for (int i = 1; i < strs.length; i++) {
            if (len == 0) {
                break;
            }
            String str = strs[i];
            if (len > str.length()) {
                len = str.length();
                res = res.substring(0, len);
            }
            while (len > 0 && !str.startsWith(res)) {
                len --;
                res = res.substring(0, len);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0014 main = new LeetCode0014();
        System.out.println(main.longestCommonPrefix(
                new String[] { "flower", "fly", "flow" }
        ));
        System.out.println(main.longestCommonPrefix(
                new String[] { "common", "long" }
        ));
    }
}