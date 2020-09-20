package com.jack.algorithm.problem.midium;

/**
 * @author fy
 */
public class LeetCode0005 {

    /**
     * 中心扩展
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = findCenter(s, i, i);
            int len2 = findCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int findCenter(String s, int l, int r) {
        int left = l;
        int right = r;
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            left --;
            right ++;
        }
        return right - left - 1;
    }

    public static void main(String[] args) {
        LeetCode0005 main = new LeetCode0005();
        main.testSubStr("babad");
        main.testSubStr("cbbd");
    }

    private void testSubStr(String srcStr) {
        System.out.println(srcStr);
        System.out.println(longestPalindrome(srcStr));
    }
}
