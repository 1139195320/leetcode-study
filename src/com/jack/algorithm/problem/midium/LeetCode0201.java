package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0201 {

    public int rangeBitwiseAnd(int m, int n) {
        if (m == n) {
            return n;
        }
        return n & rangeBitwiseAnd(m, n - 1);
    }

    public int rangeBitwiseAnd2(int m, int n) {
        while (m < n) {
            n &= (n - 1);
        }
        return m & n;
    }

    /**
     * 取高位无变化数
     */
    public int rangeBitwiseAnd3(int m, int n) {
        int shift = 0;
        while (m < n) {
            m >>= 1;
            n >>= 1;
            shift ++;
        }
        return m << shift;
    }

    public static void main(String[] args) {
        LeetCode0201 main = new LeetCode0201();
        System.out.println(main.rangeBitwiseAnd(0, 1));
        System.out.println(main.rangeBitwiseAnd(5, 7));
        System.out.println(main.rangeBitwiseAnd2(0, 1));
        System.out.println(main.rangeBitwiseAnd2(5, 7));
        System.out.println(main.rangeBitwiseAnd3(0, 1));
        System.out.println(main.rangeBitwiseAnd3(5, 7));
        System.out.println(main.rangeBitwiseAnd3(13, 15));
    }
}