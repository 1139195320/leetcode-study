package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Medium1536 {

    public int minSwaps(int[][] grid) {
        int n = grid.length;
        // 计数每一行靠右边的 0 的个数
        int[] zeroCount = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) {
                    zeroCount[i] ++;
                } else {
                    break;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            // 这一行右边的 0 需要多少个
            int curTarget = n - i - 1;
            if (zeroCount[i] >= curTarget) {
                continue;
            }
            boolean isFind = false;
            for (int j = i + 1; j < n; j++) {
                if (zeroCount[j] >= curTarget) {
                    isFind = true;
                    move(zeroCount, j, i);
                    res += j - i;
                }
            }
            if (!isFind) {
                return -1;
            }
        }
        return res;
    }
    private void move(int[] arr, int lowFrom, int highTo) {
        int tmp = arr[lowFrom];
        System.arraycopy(arr, highTo,
                arr, highTo + 1, lowFrom - highTo);
        arr[highTo] = tmp;
    }

    public static void main(String[] args) {
        Medium1536 main = new Medium1536();
        System.out.println(main.minSwaps(
                new int[][]{
                        {0, 0, 1},
                        {1, 1, 0},
                        {1, 0, 0}
                }
        ));
    }
}