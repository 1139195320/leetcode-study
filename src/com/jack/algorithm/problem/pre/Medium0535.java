package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Medium0535 {

    public int superPow(int a, int[] b) {
        int c = ol(1337);
        int sum = 0;
        for (int bb : b) {
            sum = (sum * 10 + bb) % c;
        }
        sum += c;
        return q((long) a, sum, 1337);
    }

    private int q(long x,int y,int M) {
        long res = 1;
        while (y > 0) {
            if (y % 2 > 0) {
                res = res % M * x % M;
            }
            x = x % M * x % M;
            y /= 2;
        }
        return (int)res;
    }
    /**
     * 欧拉公式
     **/
    private int ol(int x) {
        int res = x;
        for (int i = 2; i * i <= x; i++) {
            if (x % i == 0) {
                res = res - res / i;
                while (x % i == 0) {
                    x /= i;
                }
            }
        }
        if (x > 1) {
            res = res - res / x;
        }
        return res;
    }

    public static void main(String[] args) {
        Medium0535 main = new Medium0535();
    }
}