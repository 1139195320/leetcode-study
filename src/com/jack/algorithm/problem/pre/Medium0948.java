package com.jack.algorithm.problem.pre;

import java.util.Arrays;

/**
 * @author jack
 */
public class Medium0948 {

    public int bagOfTokensScore(int[] tokens, int P) {
        int res = 0;
        int curScore = 0;
        Arrays.sort(tokens);
        if (P < tokens[0]) {
            return 0;
        }
        int i = 0, j = tokens.length - 1;
        while (i < j) {
            while (i <= j && P >= tokens[i]) {
                P -= tokens[i ++];
                curScore ++;
            }
            res = Math.max(res, curScore);
            while (i < j && curScore > 0) {
                P += tokens[j --];
                curScore --;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Medium0948 main = new Medium0948();
        // 0
        System.out.println(main.bagOfTokensScore(
                new int[]{100}, 50
        ));
        // 1
        System.out.println(main.bagOfTokensScore(
                new int[]{100, 200}, 150
        ));
        // 2
        System.out.println(main.bagOfTokensScore(
                new int[]{100, 200, 300, 400}, 200
        ));
    }
}