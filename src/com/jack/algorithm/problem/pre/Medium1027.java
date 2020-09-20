package com.jack.algorithm.problem.pre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jack
 */
public class Medium1027 {

    public int longestArithSeqLength(int[] A) {
        int res = 0;
        int n = A.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                int pre = A[j];
                int dif = pre - A[i];
                int cur = 2;
                for (int k = j + 1; k < n; k++) {
                    if (A[k] == pre + dif) {
                        cur ++;
                        pre = A[k];
                    }
                }
                res = Math.max(res, cur);
            }
        }
        return res;
    }

    public int longestArithSeqLength2(int[] A) {
        int res = 0;
        int n = A.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i ++) {
            List<Integer> list = map.computeIfAbsent(A[i],
                    k -> new ArrayList<>());
            list.add(i);
        }
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                int pre = A[j];
                int dif = pre - A[i];
                int cur = 2;
                pre += dif;
                int k = j;
                while (map.containsKey(pre)) {
                    List<Integer> list = map.get(pre);
                    boolean find = false;
                    for (int l : list) {
                        if (l > k) {
                            cur ++;
                            k = l;
                            find = true;
                            break;
                        }
                    }
                    if (!find) {
                        break;
                    }
                    pre += dif;
                }
                res = Math.max(res, cur);
            }
        }
        return res;
    }

    public int longestArithSeqLength3(int[] A) {
        int n = A.length;
        if (n < 3) {
            return n;
        }
        int res = 2;
        Map<Integer, Integer>[] dp = new HashMap[n];
        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int dif = A[i] - A[j];
                // 将 i 与 j 等差连接
                if (dp[j].containsKey(dif)) {
                    // j 在前面已经有等差连接
                    dp[i].put(dif, dp[j].get(dif) + 1);
                } else {
                    dp[i].put(dif, 2);
                }
                res = Math.max(res, dp[i].get(dif));
            }
        }
        return res;
    }

    private void testLongestArithSeqLength() {
        System.out.println(longestArithSeqLength(
                new int[]{3, 6, 9, 12}
        ));
        System.out.println(longestArithSeqLength(
                new int[]{9, 4, 7, 2, 10}
        ));
        System.out.println(longestArithSeqLength(
                new int[]{20, 1, 15, 3, 10, 5, 8}
        ));
    }

    private void testLongestArithSeqLength2() {
        System.out.println(longestArithSeqLength2(
                new int[]{3, 6, 9, 12}
        ));
        System.out.println(longestArithSeqLength2(
                new int[]{9, 4, 7, 2, 10}
        ));
        System.out.println(longestArithSeqLength2(
                new int[]{20, 1, 15, 3, 10, 5, 8}
        ));
    }

    private void testLongestArithSeqLength3() {
        System.out.println(longestArithSeqLength3(
                new int[]{3, 6, 9, 12}
        ));
        System.out.println(longestArithSeqLength3(
                new int[]{9, 4, 7, 2, 10}
        ));
        System.out.println(longestArithSeqLength3(
                new int[]{20, 1, 15, 3, 10, 5, 8}
        ));
    }

    public static void main(String[] args) {
        Medium1027 main = new Medium1027();
        main.testLongestArithSeqLength();
        System.out.println();
        main.testLongestArithSeqLength2();
    }
}
