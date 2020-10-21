package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode1175 {

    private int mod = 1_000_000_007;
    public int numPrimeArrangements(int n) {
        int nZs = 0;
        for (int cur = 2; cur <= n; cur++) {
            int tmp = (int) Math.sqrt(cur);
            byte flag = 0;
            for (int i = 2; i <= tmp; i++) {
                if (cur % i == 0) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                nZs++;
            }
        }
        return (int) (jc(nZs) * jc(n - nZs) % mod);
    }
    private long jc(int n) {
        // Ann
        if (n == 0) {
            return 1;
        }
        int min = 3;
        if (n < min) {
            return n;
        }
        long res = 1;
        for (int i = 2; i <= n; i++) {
            res *= i;
            res %= mod;
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode1175 main = new LeetCode1175();
        System.out.println(main.numPrimeArrangements(100));
    }
}
