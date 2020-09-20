package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode5469 {

    public boolean canConvertString(String s, String t, int k) {
        int n = s.length();
        if (t.length() != n) {
            return false;
        }
        if (!s.equals(t) && k == 0) {
            return false;
        }
        int max = 26;
        int[] arr = new int[max];
        for (int i = 0; i < n; i ++) {
            arr[(t.charAt(i) - s.charAt(i) + max) % max] ++;
        }
        for (int i = 1; i < max; i++) {
            int has = k / 26;
            if (k % 26 >= i) {
                has ++;
            }
            if (has < arr[i]) {
                // 不够
                return false;
            }
        }
        return true;
    }
}
