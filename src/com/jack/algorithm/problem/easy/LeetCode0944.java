package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0944 {

    public int minDeletionSize(String[] A) {
        // 使剩余每一列都非降序
        int n = A.length;
        int len = A[0].length();
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (A[j].charAt(i) > A[j + 1].charAt(i)) {
                    res ++;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0944 main = new LeetCode0944();
        System.out.println(main.minDeletionSize(
                new String[] {"cba", "daf", "ghi"}
        ));
        System.out.println(main.minDeletionSize(
                new String[] {"a", "b"}
        ));
        System.out.println(main.minDeletionSize(
                new String[] {"zyx", "wvu", "tsr"}
        ));
    }
}