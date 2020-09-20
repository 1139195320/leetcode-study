package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode11610 {

    public int maxAliveYear(int[] birth, int[] death) {
        int[] arr = new int[101];
        int n = birth.length;
        for (int i = 0; i < n; i++) {
            for (int j = birth[i]; j <= death[i]; j++) {
                arr[j - 1900] ++;
            }
        }
        int max = 0;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                res = i;
            }
        }
        return res + 1900;
    }

    public int maxAliveYear2(int[] birth, int[] death) {
        int n = 102;
        int[] arr = new int[n];
        for (int i : birth) {
            arr[i - 1900] ++;
        }
        for (int i : death) {
            arr[i - 1900 + 1] --;
        }

        int[] prefixSum = new int[n];
        prefixSum[0] = arr[0];
        int max = arr[0];
        int res = 0;
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
            if (prefixSum[i] > max) {
                max = prefixSum[i];
                res = i;
            }
        }
        return res + 1900;
    }

    public static void main(String[] args) {
        LeetCode11610 main = new LeetCode11610();
        System.out.println(main.maxAliveYear(
                new int[]{1900, 1901, 1950},
                new int[]{1948, 1951, 2000}
        ));
    }
}