package com.jack.algorithm.problem.still;

import java.util.Arrays;

/**
 * @author jack
 */
public class Hard0321 {

    public int[] maxNumber2(int[] nums1, int[] nums2, int k) {
        return new int[] {};
    }

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        // 区间 i 到 j 之内的最大值下标及最大值
        int[][][] max1 = new int[m][m][2];
        int[][][] max2 = new int[n][n][2];
        for (int i = 0; i < m; i++) {
            max1[i][i][0] = i;
            max1[i][i][1] = nums1[i];
        }
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                int[] preMax = max1[i][j - 1];
                int cur = nums1[j];
                if (cur > preMax[1]) {
                    max1[i][j][0] = j;
                    max1[i][j][1] = cur;
                } else {
                    max1[i][j] = preMax;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            max2[i][i][0] = i;
            max2[i][i][1] = nums2[i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int[] preMax = max2[i][j - 1];
                int cur = nums2[j];
                if (cur > preMax[1]) {
                    max2[i][j][0] = j;
                    max2[i][j][1] = cur;
                } else {
                    max2[i][j] = preMax;
                }
            }
        }
        int[] res = new int[k];
        int pos = 0;
        int l1 = 0, l2 = 0;
        while (pos < k) {
            int need = k - pos;
            int r1 = Math.min(m - 1, m - need + (n - l2));
            int r2 = Math.min(n - 1, n - need + (m - l1));
            System.out.println("r1 = " + r1);
            System.out.println("r2 = " + r2);
            if (l1 <= r1 && l2 <= r2) {
                int[] curMax1 = max1[l1][r1];
                int[] curMax2 = max2[l2][r2];
                if (curMax1[1] > curMax2[1]) {
                    res[pos] = curMax1[1];
                    l1 = curMax1[0] + 1;
                } else if (curMax1[1] == curMax2[1]) {
                    res[pos] = curMax1[1];
                    int[] tmp1 = curMax1;
                    int[] tmp2 = curMax2;
                    boolean flag = true;
                    while (tmp1[1] == tmp2[1]) {
                        int tmpR1 = tmp1[0];
                        int tmpR2 = tmp2[0];
                        if (tmpR1 == l1 && tmpR2 == l2) {
                            // error
                            int i = curMax1[0];
                            int j = curMax2[0];
                            while (nums1[i] == nums2[j]) {
                                i ++;
                                j ++;
                                if (i == m) {
                                    flag = false;
                                    break;
                                }
                                if (j == n) {
                                    break;
                                }
                            }
                            if (nums1[i] < nums2[j]) {
                                flag = false;
                            }
                            break;
                        }
                        else if (tmpR1 == l1) {
                                break;
                            }
                        else if (tmpR2 == l2) {
                                flag = false;
                                break;
                        }
                        tmp1 = max1[l1][tmpR1 - 1];
                        tmp2 = max2[l2][tmpR2 - 1];
                    }
                    if (tmp1[1] > tmp2[1]) {
                        flag = false;
                    }
                    if (flag) {
                        l1 = curMax1[0] + 1;
                    } else {
                        l2 = curMax2[0] + 1;
                    }
                } else {
                    res[pos] = curMax2[1];
                    l2 = curMax2[0] + 1;
                }
            } else {
                if (l1 <= r1) {
                    int[] curMax1 = max1[l1][r1];
                    res[pos] = curMax1[1];
                    l1 = curMax1[0] + 1;
                } else {
                    int[] curMax2 = max2[l2][r2];
                    res[pos] = curMax2[1];
                    l2 = curMax2[0] + 1;
                }
            }
            pos ++;
        }
        return res;
    }

    public static void main(String[] args) {
        Hard0321 main = new Hard0321();
        System.out.println(Arrays.toString(main.maxNumber(
                new int[]{3, 4, 6, 5},
                new int[]{9, 1, 2, 5, 8, 3},
                5
        )));
        System.out.println(Arrays.toString(main.maxNumber(
                new int[]{6, 7},
                new int[]{6, 0, 4},
                5
        )));
        System.out.println(Arrays.toString(main.maxNumber(
                new int[]{3, 9},
                new int[]{8, 9},
                3
        )));
        System.out.println(Arrays.toString(main.maxNumber(
                new int[]{8, 9},
                new int[]{3, 9},
                3
        )));
        System.out.println(Arrays.toString(main.maxNumber(
                new int[]{2, 5, 6, 4, 4, 0},
                new int[]{7, 3, 8, 0, 6, 5, 7, 6, 2},
                15
        )));
    }
}