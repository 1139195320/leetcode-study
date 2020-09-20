package com.jack.algorithm.problem.pre;

import java.util.Arrays;

/**
 * @author jack
 */
public class Medium1053 {

    public int[] prevPermOpt1(int[] A) {
        int n = A.length;
        int curMax = -1;
        boolean flag = false;
        int index = -1;
        for (int i = n - 2; i >= 0; i--) {
            // 找到第一个比右边大的位置
            // 只要将这个位置和右边的比其小的换就会变小
            if (A[i] > A[i + 1]) {
                // 找到这个位置右边的比其小的最大的位置
                // 交换后才能最大
                for (int j = i + 1; j < n; j ++) {
                    if (A[i] > A[j]) {
                        flag = true;
                        if (A[j] > curMax) {
                            curMax = A[j];
                            index = j;
                        }
                    }
                }
                if (flag) {
                    int tmp = A[i];
                    A[i] = A[index];
                    A[index] = tmp;
                    break;
                }
            }
        }
        return A;
    }

    public static void main(String[] args) {
        Medium1053 main = new Medium1053();
        System.out.println(Arrays.toString(main.prevPermOpt1(
                new int[]{1, 1, 5}
        )));
        System.out.println(Arrays.toString(main.prevPermOpt1(
                new int[]{1, 9, 4, 6, 7}
        )));
        System.out.println(Arrays.toString(main.prevPermOpt1(
                new int[]{3, 1, 1, 3}
        )));
    }
}