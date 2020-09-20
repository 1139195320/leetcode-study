package com.jack.algorithm.problem.easy;

import java.util.Arrays;

/**
 * @author jack
 */
public class LeetCode1033 {

    public int[] numMovesStones(int a, int b, int c) {
        if (a > b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        if (a > c) {
            int tmp = a;
            a = c;
            c = tmp;
        }
        if (b > c) {
            int tmp = b;
            b = c;
            c = tmp;
        }
        int dis1 = b - a;
        int dis2 = c - b;
        int min = 2;
        if (dis1 <= 2 || dis2 <= 2) {
            min = 1;
        }
        if (dis1 == 1 && dis2 == 1) {
            min = 0;
        }
        return new int[] {min, dis1 + dis2 - 2};
    }

    public static void main(String[] args) {
        LeetCode1033 main = new LeetCode1033();
        System.out.println(Arrays.toString(
                main.numMovesStones(3, 5, 1)));
        System.out.println(Arrays.toString(
                main.numMovesStones(3, 4, 2)));
    }
}
