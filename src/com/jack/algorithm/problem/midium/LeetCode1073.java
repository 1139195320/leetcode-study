package com.jack.algorithm.problem.midium;

import java.util.Arrays;

/**
 * @author jack
 */
public class LeetCode1073 {

    public int[] addNegabinary(int[] arr1, int[] arr2) {
        // -2
        // 1 -2 4 -8 16
        int len1 = arr1.length;
        int len2 = arr2.length;
        int len = Math.max(len1, len2);
        int[] res = new int[len];
        int adder = 0;
        int full = 2;
        for (int i = 0; i < len; i++) {
            int cur = adder;
            if (i < len1) {
                cur += arr1[len1 - 1 - i];
            }
            if (i < len2) {
                cur += arr2[len2 - 1 - i];
            }
            if (cur == full + 1) {
                // cur = 2 + 1
                res[len - 1 - i] = 1;
                adder = -1;
            }
            else if (cur == full) {
                adder = -1;
            }
            else if (cur == 1) {
                res[len - 1 - i] = 1;
                adder = 0;
            }
            else if (cur == 0) {
                adder = 0;
            }
            else if (cur == -1) {
                res[len - 1 - i] = 1;
                adder = 1;
            }
        }
        if (adder == -1) {
            int[] newRes = new int[len + 2];
            System.arraycopy(res, 0, newRes, 2, len);
            newRes[0] = 1;
            newRes[1] = 1;
            return newRes;
        }
        // 去掉前缀 0
        int i = 0;
        while (i < len && res[i] == 0) {
            i ++;
        }
        if (i == len) {
            // 全部是 0
            return new int[]{0};
        }
        if (i > 0) {
            int[] newRes = new int[len - i];
            System.arraycopy(res, i, newRes, 0, len - i);
            return newRes;
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode1073 main = new LeetCode1073();
        System.out.println(Arrays.toString(main.addNegabinary(
                new int[]{1},
                new int[]{1, 0, 1}
        )));
        System.out.println(Arrays.toString(main.addNegabinary(
                new int[]{1, 1, 1, 1, 1},
                new int[]{1, 0, 1}
        )));
        System.out.println(Arrays.toString(main.addNegabinary(
                new int[]{1},
                new int[]{1}
        )));
        System.out.println(Arrays.toString(main.addNegabinary(
                new int[]{1, 1, 0},
                new int[]{1, 0}
        )));
    }
}
