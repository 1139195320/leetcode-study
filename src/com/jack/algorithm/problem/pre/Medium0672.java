package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Medium0672 {

    public int flipLights(int n, int m) {
        n = Math.min(n, 3);
        if (m == 0) {
            return 1;
        }
        if (m == 1) {
            return n + 1;
        }
        if (m == 2) {
            return n == 1 ? 2 : n == 2 ? 4 : 7;
        }
        return n == 1 ? 2 : n == 2 ? 4 : 8;
    }

    public static void main(String[] args) {
        Medium0672 main = new Medium0672();
        System.out.println(main.flipLights(1, 1));
        System.out.println(main.flipLights(2, 1));
        System.out.println(main.flipLights(3, 1));
    }
}