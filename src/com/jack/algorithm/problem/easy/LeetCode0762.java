package com.jack.algorithm.problem.easy;

import java.util.Arrays;
import java.util.List;

/**
 * @author jack
 */
public class LeetCode0762 {

    public int countPrimeSetBits(int L, int R) {
        // 2 4 8 16 32 64 128 256 512 1024
        List<Integer> list = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19);
        int len1 = Integer.toBinaryString(L).length();
        int len2 = Integer.toBinaryString(R).length();
        int res = 0;
        if (len1 == len2) {
            for (int i = L; i <= R; i++) {
                if (list.contains(Integer.bitCount(i))) {
                    res ++;
                }
            }
            return res;
        }
        for (int i = L; i < (1 << (len1)); i++) {
            if (list.contains(Integer.bitCount(i))) {
                res ++;
            }
        }
        for (int i = (1 << (len2 - 1)); i <= R; i++) {
            if (list.contains(Integer.bitCount(i))) {
                res ++;
            }
        }
        if (len2 > len1 + 1) {
            int cur = len1 + 1;
            while (cur < len2) {
                for (Integer tmp : list) {
                    if (cur < tmp) {
                        break;
                    }
                    if (cur == tmp) {
                        res += 1;
                        break;
                    }
                    // 从 cur - 1 中选 tmp - 1
                    int a = cur - 1;
                    int b = Math.min(tmp - 1, a - tmp + 1);
                    int up = 1, down = 1;
                    for (int i = 0; i < b; i++) {
                        up *= (a - i);
                        down *= (i + 1);
                    }
                    res += up / down;
                }
                cur ++;
            }
        }
        return res;
    }

    public int countPrimeSetBits2(int L, int R) {
        int res = 0;
        List<Integer> list = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19);
        for (int i = L; i <= R; i++) {
            if (list.contains(Integer.bitCount(i))) {
                res ++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0762 main = new LeetCode0762();
        System.out.println(main.countPrimeSetBits(4, 85));
    }
}
