package com.jack.algorithm.problem.pre;

import java.util.Arrays;

/**
 * @author jack
 */
public class Easy11615 {

    public int[] masterMind(String solution, String guess) {
        int right = 0;
        int falseRight = 0;
        int len = solution.length();
        // 0-R 1-Y 2-G 3-B
        char[] target = {'R', 'Y', 'G', 'B'};
        int[][] arr = new int[2][26];
        char[] solutionArr = solution.toCharArray();
        char[] guessArr = guess.toCharArray();
        for (int i = 0; i < len; i++) {
            char c1 = solutionArr[i];
            char c2 = guessArr[i];
            if (c1 == c2) {
                right ++;
                continue;
            }
            arr[0][c1 - 'A'] ++;
            arr[1][c2 - 'A'] ++;
        }
        for (char c : target) {
            int a = arr[0][c - 'A'];
            int b = arr[1][c - 'A'];
            if (a != 0 && b != 0) {
                falseRight += Math.abs(a - b);
            }
        }
        return new int[]{right, falseRight};
    }

    public static void main(String[] args) {
        Easy11615 main = new Easy11615();
        System.out.println(Arrays.toString(
                main.masterMind("RGBY", "GGRR")));
    }
}