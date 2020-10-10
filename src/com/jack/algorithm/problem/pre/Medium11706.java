package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Medium11706 {

    public int numberOf2sInRange(int n) {
        if (n <= 1) {
            return 0;
        }
        int digit = (int) Math.log10(n) + 1;
        int [][] dp = new int[digit + 1][2];
        // dp[i][0] = numberOf2sInRange(n % pow(10, i)) 保存0~n的1-i位组成的数包含2的个数
        // dp[i][1] = numberOf2sInRange(99..9) 保存i位均为9包含2的个数
        dp[1][0] = n % 10 >= 2 ? 1 : 0;
        dp[1][1] = 1;
        for (int i = 2; i <= digit; i++) {
            int k = n / ((int) Math.pow(10, i - 1)) % 10;
            dp[i][0] = k * dp[i - 1][1] + dp[i - 1][0];
            if (k == 2) {
                dp[i][0] += n % (int) Math.pow(10, i - 1) + 1;
            } else if (k > 2) {
                dp[i][0] += (int) Math.pow(10, i - 1);
            }
            // 计算当 i - 1 位均为 9 时的值包含 2 的个数
            dp[i][1] = 10 * dp[i - 1][1] + (int) Math.pow(10, i - 1);
        }
        return dp[digit][0];
    }

    public static void main(String[] args) {
        Medium11706 main = new Medium11706();
        System.out.println(main.numberOf2sInRange(8));
        System.out.println(main.numberOf2sInRange(78));
        System.out.println(main.numberOf2sInRange(478));
        System.out.println(main.numberOf2sInRange(25));
    }
}