package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0319 {

    public int bulbSwitch(int n) {
        // 有多少个因子，该开关就会被按多少次
        // 所以按奇数次的灯才会是亮的
        // 只有完全平方数的因子个数是奇数
        return (int) Math.sqrt(n);
    }

    public int bulbSwitch2(int n) {
        int res = 0;
        if (n == 1) {
            return 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j * j > i) {
                    break;
                } else if (j * j == i) {
                    res ++;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0319 main = new LeetCode0319();
        System.out.println(main.bulbSwitch(1));
        System.out.println(main.bulbSwitch(2));
        System.out.println(main.bulbSwitch(3));
        System.out.println(main.bulbSwitch(4));
        System.out.println(main.bulbSwitch(5));
    }
}