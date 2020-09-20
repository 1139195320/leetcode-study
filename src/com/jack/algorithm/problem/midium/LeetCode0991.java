package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0991 {

    public int brokenCalc(int x, int y) {
        if (x >= y) {
            return x - y;
        }
        int count = 0;
        // 找到一个比 x 小，且通过 ×2 和 -1 能到达 y 的数
        // 通过倒推
        // 能整 ÷2 则 ÷2，否则就 +1
        while (y > x) {
            if ((y & 1) != 0) {
                y ++;
                count ++;
            }
            y >>= 1;
            count ++;
        }
        return count + (x - y);
    }

    public static void main(String[] args) {
        LeetCode0991 main = new LeetCode0991();
        System.out.println(main.brokenCalc(1, 5));
        System.out.println(main.brokenCalc(1, 10));
        System.out.println(main.brokenCalc(2, 3));
        System.out.println(main.brokenCalc(5, 8));
        System.out.println(main.brokenCalc(3, 10));
    }
}