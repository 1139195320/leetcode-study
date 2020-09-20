package com.jack.algorithm.problem.hard;

/**
 * @author jack
 */
public class LeetCode0902 {

    public int atMostNGivenDigitSet(String[] D, int N) {
        int n = D.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(D[i]);
        }
        int len = 0;
        int tmp = N;
        long multipleL = 1;
        while (tmp > 0) {
            len ++;
            tmp /= 10;
            multipleL *= 10;
        }
        int multiple = (int) (multipleL / 10);
        int count = 0;
        int tLen = len;
        // 先看位数比 N 小的数有多少个
        while (tLen > 1) {
            tLen --;
            count = (count + 1) * n;
        }
        // 所有数都小于 N 的最高位
        if (arr[n - 1] < N / multiple) {
            return (count + 1) * n;
        }
        // 再看位数与 N 相同时有多少个
        while (N > 0) {
            int cur = N / multiple;
            int c = 0;
            int curC = arr[0];
            for (int i : arr) {
                curC = i;
                if (curC < cur) {
                    c ++;
                } else {
                    break;
                }
            }
            if (c > 0) {
                // 有小于当前位置数的就可以计算数量
                count += (c * Math.pow(n, len - 1));
            }
            // 小于当前位置数的已计算
            // 有等于当前位置数的才继续下一个位置
            if (curC > cur) {
                break;
            }
            N %= multiple;
            // 数相等且到最后一位了
            if (curC == cur && N == 0 && len == 1) {
                count ++;
            }
            multiple /= 10;
            len --;
            if (n == 1) {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LeetCode0902 main = new LeetCode0902();
        // 126
        System.out.println(main.atMostNGivenDigitSet(
                new String[]{"1", "2"}, 658484
        ));
        // 3
        System.out.println(main.atMostNGivenDigitSet(
                new String[]{"1"}, 834
        ));
        // 2
        System.out.println(main.atMostNGivenDigitSet(
                new String[]{"3", "4", "9"}, 4
        ));
        // 4
        System.out.println(main.atMostNGivenDigitSet(
                new String[]{"3", "4"}, 34
        ));
        // 18
        System.out.println(main.atMostNGivenDigitSet(
                new String[]{"1", "4", "9"}, 150
        ));
        // 20
        System.out.println(main.atMostNGivenDigitSet(
                new String[]{"1", "3", "5", "7"}, 100
        ));
        // 29523
        System.out.println(main.atMostNGivenDigitSet(
                new String[]{"1", "4", "9"}, 1000000000
        ));
        System.out.println(main.atMostNGivenDigitSet(
                new String[]{"1", "4", "9"}, 1000000009
        ));
    }
}