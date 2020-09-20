package com.jack.algorithm.problem.pre;

import java.util.Arrays;

/**
 * @author jack
 */
public class Medium1405 {

    private int[][] arr;
    private int[] count;
    private void sort(int[][] arr) {
        Arrays.sort(arr, (a, b) -> b[1] - a[1]);
    }
    private void put(StringBuilder sb, int pos) {
        // 当前谁最多就放谁
        if (pos >= arr.length || pos < 0) {
            return;
        }
        if (arr[pos][1] == 0) {
            // 最多的数量是 0
            return;
        }
        int cur = arr[pos][0];
        if (count[cur] >= 2) {
            // 当前的不能放就试一试下一个
            put(sb, pos + 1);
            return;
        }
        // 0-a 1-b 2-c
        sb.append((char) ('a' + cur));
        // 当前的剩余的数量减一
        arr[pos][1]--;
        // 当前的放进去后计数需更新
        for (int i = 0; i < count.length; i++) {
            if (i == cur) {
                count[i] ++;
            } else {
                count[i] = 0;
            }
        }
    }
    public String longestDiverseString(int a, int b, int c) {
        int n = a + b + c;
        StringBuilder sb = new StringBuilder(n);
        // ij j0-a j1-b j2-c
        arr = new int[3][2];
        arr[0][0] = 0;
        arr[0][1] = a;
        arr[1][0] = 1;
        arr[1][1] = b;
        arr[2][0] = 2;
        arr[2][1] = c;
        count = new int[3];
        for (int i = 0; i < n; i++) {
            sort(arr);
            put(sb, 0);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Medium1405 main = new Medium1405();
        System.out.println(main.longestDiverseString(1, 1, 7));
        System.out.println(main.longestDiverseString(2, 2, 1));
        System.out.println(main.longestDiverseString(7, 1, 0));
        System.out.println(main.longestDiverseString(100, 100, 100));
    }
}