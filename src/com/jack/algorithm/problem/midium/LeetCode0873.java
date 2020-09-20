package com.jack.algorithm.problem.midium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jack
 */
public class LeetCode0873 {

    public int lenLongestFibSubseq(int[] A) {
        int res = 0;
        int n = A.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int a = A[i];
                list.add(a);
                int b = A[j];
                list.add(b);
                int k = j + 1;
                while (k < n) {
                    int c = A[k];
                    if (a + b == c) {
                        list.add(c);
                        a = b;
                        b = c;
                    } else if (a + b < c) {
                        break;
                    }
                    k ++;
                }
                if (list.size() >= 3) {
                    res = Math.max(res, list.size());
                }
                list.clear();
            }
        }
        return res;
    }

    public int lenLongestFibSubseq2(int[] A) {
        int res = 0;
        int n = A.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int cur = 2;
                int a = A[i];
                int b = A[j];
                int k = j + 1;
                while (k < n) {
                    int c = A[k];
                    if (a + b == c) {
                        cur ++;
                        a = b;
                        b = c;
                    } else if (a + b < c) {
                        break;
                    }
                    k ++;
                }
                if (cur >= 3) {
                    res = Math.max(res, cur);
                }
            }
        }
        return n >= 3 ? res : 0;
    }

    public int lenLongestFibSubseq3(int[] A) {
        int n = A.length;
        Set<Integer> set = new HashSet<>();
        for (int a : A) {
            set.add(a);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x = A[j], y = A[i] + A[j];
                int cur = 2;
                while (set.contains(y)) {
                    int tmp = y;
                    y += x;
                    x = tmp;
                    res = Math.max(res, ++ cur);
                }
            }
        }
        return res >= 3 ? res : 0;
    }

    public static void main(String[] args) {
        LeetCode0873 main = new LeetCode0873();
        System.out.println(main.lenLongestFibSubseq(
                new int[]{1, 2, 3, 4, 5, 6, 7, 8}
        ));
        System.out.println(main.lenLongestFibSubseq(
                new int[]{1, 3, 7, 11, 12, 14, 18}
        ));
        System.out.println(main.lenLongestFibSubseq2(
                new int[]{1, 2, 3, 4, 5, 6, 7, 8}
        ));
        System.out.println(main.lenLongestFibSubseq2(
                new int[]{1, 3, 7, 11, 12, 14, 18}
        ));
    }
}