package com.jack.algorithm.problem.easy;

/**
 * @author fy
 */
public class LeetCode0069 {

    public int mySqrt2(int x) {
        if (x == 0) {
            return 0;
        }
        int l = 1;
        int r = 46341;
        int m;
        while (true) {
            m = (l + r) / 2;
            int temp = m * m;
            if (temp <= x && temp > 0) {
                int temp2 = (m + 1) * (m + 1);
                if (temp2 > x || temp2 < 0) {
                    break;
                }
                l = m;
            } else {
                r = m;
            }
        }
        return m;
    }
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int res = 1;
        if (x >= 4) {
            res = 2;
            int temp = 4;
            while (temp <= x && temp > 0) {
                res ++;
                temp = res * res;
            }
            res --;
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0069 main = new LeetCode0069();
        System.out.println(main.mySqrt2(1));
        System.out.println(main.mySqrt2(2));
        System.out.println(main.mySqrt2(3));
        System.out.println(main.mySqrt2(4));
        System.out.println(main.mySqrt2(5));
        System.out.println(main.mySqrt2(6));
        System.out.println(main.mySqrt2(7));
        System.out.println(main.mySqrt2(8));
        System.out.println(main.mySqrt2(9));
        System.out.println(main.mySqrt2(10));
        System.out.println(main.mySqrt2(Integer.MAX_VALUE));
    }
}
