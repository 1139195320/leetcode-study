package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode10805 {

    public int multiply(int A, int B) {
        if (A == 0 || B == 0) {
            return 0;
        }
        int max = A;
        int min = B;
        if (A < B) {
            min = A;
            max = B;
        }
        if (min == 1) {
            return max;
        }
        return max + multiply(max, min - 1);
    }

    public static void main(String[] args) {
        LeetCode10805 main = new LeetCode10805();
        System.out.println(main.multiply(3, 6));
    }
}