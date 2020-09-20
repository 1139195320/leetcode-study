package com.jack.algorithm.problem.pre;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author jack
 */
public class Medium0870 {

    public int[] advantageCount(int[] A, int[] B) {
        int n = B.length;
        int[][] tmpB = new int[n][2];
        for (int i = 0; i < n; i++) {
            tmpB[i][0] = B[i];
            tmpB[i][1] = i;
        }
        Arrays.sort(tmpB, Comparator.comparingInt(a -> a[0]));
        int[] tmpA = A.clone();
        Arrays.sort(tmpA);
        if (tmpA[n - 1] <= tmpB[0][0]) {
            // 数量为 0
            return A;
        }
        int i = n - 1, j = n - 1;
        List<Integer> noSet = new ArrayList<>();
        while (j >= 0) {
            if (tmpA[i] > tmpB[j][0]) {
                // 用掉了一个数
                A[tmpB[j][1]] = tmpA[i];
                tmpA[i] = -1;
                i --;
            } else {
                // 没有合适的填充的数的位置
                noSet.add(tmpB[j][1]);
            }
            j --;
        }
        // 填充没有填充的位置
        for (int index : noSet) {
            A[index] = tmpA[i --];
        }
        return A;
    }

    public static void main(String[] args) {
        Medium0870 main = new Medium0870();
        System.out.println(Arrays.toString(main.advantageCount(
                new int[]{2, 7, 11, 15},
                new int[]{1, 10, 4, 11}
        )));
        System.out.println(Arrays.toString(main.advantageCount(
                new int[]{12, 24, 8, 32},
                new int[]{13, 25, 32, 11}
        )));
    }
}