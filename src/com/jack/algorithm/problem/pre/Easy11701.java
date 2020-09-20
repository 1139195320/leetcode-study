package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Easy11701 {

    public int add(int a, int b) {
        if (b == 0) {
            return a;
        }
        return add(a ^ b, (a & b) << 1);
    }

    public static void main(String[] args) {
        Easy11701 main = new Easy11701();
        System.out.println(main.add(2, 4));
    }
}