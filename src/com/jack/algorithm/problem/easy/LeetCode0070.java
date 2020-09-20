package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0070 {

    public int climbStairs(int n) {
        return doClimbStairs(0 ,n) + 1;
    }
    private int doClimbStairs(int visited, int n) {
        int res = 0;
        if (visited + 1 <= n) {
            res += doClimbStairs(visited + 1, n);
        }
        if (visited + 2 <= n) {
            res += doClimbStairs(visited + 2, n) + 1;
        }
        return res;
    }

    public int climbStairs2(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return climbStairs2(n - 1) + climbStairs2(n - 2);
    }

    public int climbStairs3(int n) {
        int p = 0;
        int q = 0;
        int r = 1;
        for (int i = 0; i < n; i++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

    /**
     * f(n)=f(n−1)+f(n−2) 找通项公式
     */
    public int climbStairs4(int n) {
        double sqrt5 = Math.sqrt(5);
        double a = Math.pow((1 + sqrt5) / 2, n + 1)
                - Math.pow((1- sqrt5) / 2, n + 1);
        return (int) (a / sqrt5);
    }

    public static void main(String[] args) {
        LeetCode0070 main = new LeetCode0070();
        System.out.println(main.climbStairs(1));
        System.out.println(main.climbStairs(2));
        System.out.println(main.climbStairs(3));
        System.out.println(main.climbStairs(4));
        System.out.println(main.climbStairs(5));
        System.out.println();
        System.out.println(main.climbStairs2(1));
        System.out.println(main.climbStairs2(2));
        System.out.println(main.climbStairs2(3));
        System.out.println(main.climbStairs2(4));
        System.out.println(main.climbStairs2(5));
        System.out.println(main.climbStairs3(44));
        System.out.println(main.climbStairs4(44));
    }
}