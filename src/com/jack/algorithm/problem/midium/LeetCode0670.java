package com.jack.algorithm.problem.midium;

import java.util.Arrays;

/**
 * @author jack
 */
public class LeetCode0670 {

    public int maximumSwap(int num) {
        String str = String.valueOf(num);
        int n = str.length();
        if (n <= 1) {
            return num;
        }
        // 10969 -> 90961
        // 1-原来的数字，2-原来的数字所在的位置
        int[][] arr = new int[n][2];
        char[] chars = str.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            arr[i][0] = chars[i] - '0';
            arr[i][1] = i;
        }
        Arrays.sort(arr, (a, b) -> b[0] - a[0]);
        // 找到最前面的不构成最大的那个数字
        // 即要交换的左边那个数字的位置
        int l = -1;
        int errorTarget = -1;
        for (int i = 0; i < len; i++) {
            int curTarget = arr[i][0];
            if (chars[i] - '0' != curTarget) {
                l = i;
                errorTarget = curTarget;
                break;
            }
        }
        if (l == -1) {
            // 已经是最大，不需要交换
            return num;
        }
        int lNumber = chars[l] - '0';
        // 找到需要交换的右边那个数字的位置
        int r = -1;
        for (int i = len - 1; i >= 0; i--) {
            if (chars[i] - '0' == errorTarget) {
                r = i;
                break;
            }
        }
        int rNumber = chars[r] - '0';
        // 进行交换
        int tmp1 = (int) Math.pow(10, len - 1 - l);
        int tmp2 = (int) Math.pow(10, len - 1 - r);
        num = num - tmp1 * lNumber - tmp2 * rNumber
                + tmp1 * rNumber + tmp2 * lNumber;
        return num;
    }

    public static void main(String[] args) {
        LeetCode0670 main = new LeetCode0670();
        System.out.println(main.maximumSwap(2736));
    }
}
