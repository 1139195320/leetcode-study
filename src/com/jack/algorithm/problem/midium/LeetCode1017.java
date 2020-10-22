package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode1017 {

    public String baseNeg2(int n) {
        if (n == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            int y = n % -2;
            n /= -2;
            if (y == -1) {
                // 余 -1
                sb.insert(0, 1);
                n ++;
            } else {
                // 余 0 1
                sb.insert(0, y);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode1017 main = new LeetCode1017();
        System.out.println(main.baseNeg2(3));
        System.out.println(main.baseNeg2(-3));
    }
}
