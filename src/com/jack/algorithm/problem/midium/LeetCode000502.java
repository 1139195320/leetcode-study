package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode000502 {

    /**
     * 中心扩展
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        int startIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = findCenter(s, i, i);
            int len2 = findCenter(s, i, i + 1);
            int curMaxLen = Math.max(len1, len2);
            if (endIndex - startIndex < curMaxLen) {
                startIndex = i - (curMaxLen - 1) / 2;
                endIndex = i + curMaxLen / 2;
            }
        }
        return s.substring(startIndex, endIndex + 1);
    }

    private int findCenter(String s, int l, int r) {
        int len = 0;
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            len = r - l + 1;
            l--;
            r++;
        }
        return len;
    }

    public static void main(String[] args) {
        LeetCode000502 main = new LeetCode000502();
        main.testSubStr("babad");
        main.testSubStr("cbbd");
        main.testSubStr("ac");
    }

    private void testSubStr(String srcStr) {
        System.out.println(srcStr);
        System.out.println(longestPalindrome(srcStr));
    }
}
