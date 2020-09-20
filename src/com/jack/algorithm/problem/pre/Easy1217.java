package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Easy1217 {

    public int minCostToMoveChips(int[] chips) {
        int countA = 0;
        int countB = 0;
        for (int chip : chips) {
            if ((chip & 1) == 0) {
                countA ++;
            } else {
                countB ++;
            }
        }
        return Math.min(countA, countB);
    }

    public static void main(String[] args) {
        Easy1217 main = new Easy1217();
        System.out.println(main.minCostToMoveChips(
                new int[] {1, 1, 2, 2, 3}
        ));
    }
}