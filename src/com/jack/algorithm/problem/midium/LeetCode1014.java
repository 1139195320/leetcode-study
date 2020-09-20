package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode1014 {

    public int maxScoreSightseeingPair(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int res = 0;
        int i = 1;
        int cur = A[0];
        while (i < A.length) {
            res = Math.max(res, A[i] - i + cur);
            cur = Math.max(cur, A[i] + i);
            i ++;
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode1014 main = new LeetCode1014();
        System.out.println(main.maxScoreSightseeingPair(
                new int[] {8, 1, 5, 2, 6}
        ));
    }
}