package com.jack.algorithm.problem.midium;

import java.util.Arrays;

/**
 * @author jack
 */
public class LeetCode1371 {

    public int findTheLongestSubstring(String s) {
        int res = 0;
        int[] pos = new int[1 << 5];
        Arrays.fill(pos, -1);
        pos[0] = 0;
        int status = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                status ^= (1);
            } else if (ch == 'e') {
                status ^= (1 << 1);
            } else if (ch == 'i') {
                status ^= (1 << 2);
            } else if (ch == 'o') {
                status ^= (1 << 3);
            } else if (ch == 'u') {
                status ^= (1 << 4);
            }
            if (pos[status] >= 0) {
                res = Math.max(res, i + 1 - pos[status]);
            } else {
                pos[status] = i + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode1371 main = new LeetCode1371();
        System.out.println(main.findTheLongestSubstring("eleetminicoworoep"));
        System.out.println(main.findTheLongestSubstring("leetcodeisgreat"));
        System.out.println(main.findTheLongestSubstring("bcbcbc"));
    }
}
