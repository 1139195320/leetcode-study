package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0754 {

    public int reachNumber(int target) {
        target = Math.abs(target);
        int c = 0;
        while (target > 0) {
            target -= ++c;
        }
        return target % 2 == 0 ? c : c + 1 + c % 2;
    }

    public static void main(String[] args) {
        LeetCode0754 main = new LeetCode0754();
        System.out.println(main.reachNumber(3));
        System.out.println(main.reachNumber(2));
    }
}