package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode1525 {

    public int numSplits(String s) {
        // 保存右边一段的信息
        int[] right = new int[26];
        int rightCount = 0;
        // 保存左边一段的信息
        int[] left = new int[26];
        int leftCount = 0;
        int res = 0;
        char[] arr = s.toCharArray();
        for (char c : arr) {
            int tmp = c - 'a';
            if (right[tmp] == 0) {
                rightCount ++;
            }
            right[tmp] ++;
        }
        for (char c : arr) {
            int tmp = c - 'a';
            // 从右边剥离这个到左边
            right[tmp] --;
            if (right[tmp] == 0) {
                rightCount --;
            }
            if (left[tmp] == 0) {
                leftCount ++;
            }
            left[tmp] ++;
            if (leftCount == rightCount) {
                res ++;
            }
        }
        return res;
    }
}
