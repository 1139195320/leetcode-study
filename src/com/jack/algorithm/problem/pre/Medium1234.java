package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Medium1234 {

    public int balancedString(String s) {
        int res = 0;
        // 里面存储 'Q','W','E','R' 在窗口外的数量
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            arr[c - 'A'] ++;
        }
        int l = 0;
        int r = 0;
        int len = s.length();
        int target = len / 4;
        while (r < len) {
            // 将 r 进窗口
            arr[s.charAt(r) - 'A'] --;
            // 有缺的，不满足 target 的，则必有数量大于 target 的
            while (l < len
                    && arr['Q' - 'A'] <= target
                    && arr['W' - 'A'] <= target
                    && arr['E' - 'A'] <= target
                    && arr['R' - 'A'] <= target) {
                res = Math.min(res, r - l + 1);
                // 将 l 出窗口
                arr[s.charAt(l) - 'A'] ++;
                // 缩小窗口
                l ++;
            }
            // 扩大窗口
            r ++;
        }
        return res;
    }
}
