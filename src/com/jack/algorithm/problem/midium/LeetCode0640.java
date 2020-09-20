package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0640 {

    public String solveEquation(String equation) {
        // 化简成 a * x = b
        int n = equation.length();
        int i = 0;
        int a = 0, b = 0;
        // 记录当前是否循环在 = 的左边
        boolean isLeft = true;
        // 当前数前面的符号默认为 +
        char pre = '+';
        while (i < n) {
            char c = equation.charAt(i);
            if (Character.isDigit(c)) {
                int cur = c - '0';
                while (i + 1 < n && Character.isDigit(equation.charAt(i + 1))) {
                    i ++;
                    cur = cur * 10 + (equation.charAt(i) - '0');
                }
                if (i + 1 >= n || equation.charAt(i + 1) != 'x') {
                    // 当前不是 x 的系数，即常数
                    if ((isLeft && pre == '+') || (!isLeft && pre == '-')) {
                        b -= cur;
                    } else {
                        b += cur;
                    }
                } else {
                    // 当前是 x 的系数
                    if ((isLeft && pre == '+') || (!isLeft && pre == '-')) {
                        a += cur;
                    } else {
                        a -= cur;
                    }
                    i ++;
                }
            } else if (c == '=') {
                isLeft = false;
                // 到了 = 右边，先将前面的符号重置成 +
                pre = '+';
            } else if (c == 'x') {
                // x 的系数为 1
                if ((isLeft && pre == '+') || (!isLeft && pre == '-')) {
                    a += 1;
                } else {
                    a -= 1;
                }
            } else {
                // + -
                pre = c;
            }
            i ++;
        }
        if (a == 0 && b == 0) {
            // 0 * 任意数 = 0
            return "Infinite solutions";
        }
        return a == 0 ? "No solution" : "x=" + (b / a);
    }

    public static void main(String[] args) {
        LeetCode0640 main = new LeetCode0640();
        System.out.println(main.solveEquation("2x=x"));
        System.out.println(main.solveEquation("x=x"));
        System.out.println(main.solveEquation("x+5-3+x=6+x-2"));
        System.out.println(main.solveEquation("2x+3x-6x=x+2"));
        System.out.println(main.solveEquation("x=x+2"));
    }
}