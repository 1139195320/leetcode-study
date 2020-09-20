package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Medium0775 {

    public boolean isIdealPermutation(int[] A) {
        int n = A.length;
        if (n < 3) {
            return true;
        }
        int preMax = A[0];
        int pre = A[1];
        for (int i = 2; i < n; i++) {
            int cur = A[i];
            if (preMax > cur) {
                return false;
            }
            preMax = Math.max(preMax, pre);
            pre = cur;
        }
        return true;
    }

    public static void main(String[] args) {
        Medium0775 main = new Medium0775();
        System.out.println(main.isIdealPermutation(
                new int[] {1, 0, 2}
        ));
        System.out.println(main.isIdealPermutation(
                new int[] {1, 2, 0}
        ));
    }
}