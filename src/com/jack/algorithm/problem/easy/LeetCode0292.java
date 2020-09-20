package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0292 {

    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    public static void main(String[] args) {
        LeetCode0292 main = new LeetCode0292();
        System.out.println(main.canWinNim(4));
        System.out.println(main.canWinNim(9));
    }
}