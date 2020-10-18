package com.jack.algorithm.problem.midium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jack
 */
public class LeetCode0592 {

    public String fractionAddition(String expression) {
        char[] srcArr = expression.toCharArray();
        List<int[]> list = new ArrayList<>();
        int i = 0;
        char tc = '/';
        while (i < srcArr.length) {
            int l = i;
            while (tc != srcArr[i]) {
                i ++;
            }
            int num1 = Integer.parseInt(expression.substring(l, i));
            // 跳过 /
            i ++;
            l = i;
            while (i < srcArr.length && Character.isDigit(srcArr[i])) {
                i ++;
            }
            int num2 = Integer.parseInt(expression.substring(l, i));
            list.add(new int[]{num1, num2});
        }
        int[] cur = list.get(0);
        for (int j = 1; j < list.size(); j++) {
            cur = cal(cur, list.get(j));
        }
        return cur[0] + "/" + cur[1];
    }
    private int[] cal(int[] a, int[] b) {
        int x1 = a[0], y1 = a[1];
        int x2 = b[0], y2 = b[1];
        if (a[0] == 0) {
            return b;
        }
        if (b[0] == 0) {
            return a;
        }
        // 分母的最小公倍数
        // 新的分母
        int g = y1 * y2 / gcd(y1, y2);
        // 新的分子
        int x = x1 * (g / y1) + x2 * (g / y2);
        if (x == 0) {
            return new int[]{0, 1};
        }
        // 分子分母约分返回
        int tmp = Math.abs(gcd(x, g));
        return new int[]{x / tmp, g / tmp};
    }
    private int gcd(int x, int y) {
        // 求最大公约数
        if (x == 0) {
            return y;
        }
        return gcd(y % x, x);
    }

    public static void main(String[] args) {
        LeetCode0592 main = new LeetCode0592();
        System.out.println(main.fractionAddition("1/3-1/2"));
        System.out.println(main.fractionAddition("-1/2+1/2"));
        System.out.println(main.fractionAddition("-1/2+1/2+1/3"));
        System.out.println(main.fractionAddition("5/3+1/3"));
    }
}
