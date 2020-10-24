package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode1024 {

    public int videoStitching(int[][] clips, int t) {
        // 从当前 i 开始能到达的最大 r
        int[] maxToR = new int[t];
        for (int[] clip : clips) {
            int cur = clip[0];
            if (cur < t) {
                maxToR[cur] = Math.max(maxToR[cur], clip[1]);
            }
        }
        int res = 0;
        int pre = 0, last = 0;
        for (int i = 0; i < t; i++) {
            last = Math.max(last, maxToR[i]);
            if (last == i) {
                // 到这儿断了线，不能继续往后拼接
                return -1;
            }
            if (i == pre) {
                res ++;
                pre = last;
            }
        }
        return res;
    }
}
