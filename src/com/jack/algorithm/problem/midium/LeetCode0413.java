package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0413 {

    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length;
        if (n < 3) {
            return 0;
        }
        // dp[i][j]：下标从 i 到 j 的数组中等差子数组的个数
        int[][] dp = new int[n + 1][n + 1];
        int count = 0;
        for (int i = 0; i < n - 2;) {
            while (i < n - 2 && A[i + 2] - A[i + 1] != A[i + 1] - A[i]) {
                i ++;
            }
            // i 右边至少得有 2 个元素才能开始组成可能符合的子数组
            if (i == n - 2) {
                break;
            }
            // 下标从 i 到 i + 2 的数组开始是第一个等差子数组
            dp[i][i + 2] = 1;
            int j = i + 3;
            if (j < n) {
                int cur = 1;
                // 循环直到此等差结束
                for (; j < n; j++) {
                    if (A[j] - A[j - 1] == A[j - 1] - A[j - 2]) {
                        dp[i][j] = dp[i][j - 1] + (j - i) - 1;
                        cur = dp[i][j];
                    } else {
                        break;
                    }
                }
                count += cur;
            } else {
                count += 1;
            }
            i = j - 1;
        }
        return count;
    }

    public int numberOfArithmeticSlices2(int[] A) {
        int[] dp = new int[A.length];
        int sum = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                sum += dp[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        LeetCode0413 main = new LeetCode0413();
        System.out.println(main.numberOfArithmeticSlices(
                new int[] {1, 2, 3, 5, 6, 7}
        ));
        System.out.println(main.numberOfArithmeticSlices(
                new int[] {1, 2, 5}
        ));
        System.out.println(main.numberOfArithmeticSlices(
                new int[] {1, 2, 3, 4, 6, 7, 8, 9, 12, 15}
        ));
    }
}