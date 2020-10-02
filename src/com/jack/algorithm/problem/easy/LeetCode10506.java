package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode10506 {

    public int convertInteger(int a, int b) {
        return Integer.bitCount(a ^ b);
    }

    public static void main(String[] args) {
        LeetCode10506 main = new LeetCode10506();
        System.out.println(main.convertInteger(29, 15));
        System.out.println(main.convertInteger(1, 2));
    }
}
