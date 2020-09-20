package com.jack.algorithm.problem.pre;

import java.util.*;

/**
 * @author jack
 */
public class Hard1434 {

    public int numberWays(List<List<Integer>> hats) {
        int MOD = 1_000_000_007;
        // 人数
        int n = hats.size();
        // 帽子最大数量
        int m = 40;
        // 数据中帽子最大下标
        int maxHat = 0;
        // hat -> person
        Map<Integer, List<Integer>> hatPersonMap = new HashMap<>(m);
        for (int i = 0; i < hats.size(); i++) {
            for (int hat : hats.get(i)) {
                hatPersonMap.computeIfAbsent(hat,
                        k -> new ArrayList<>())
                        .add(i);
                maxHat = Math.max(maxHat, hat);
            }
        }
        // 因为下标是从 0 开始的
        int count = maxHat + 1;
        // i 个帽子，分配状态为 j （记录哪些人分配了）
        int[][] dp = new int[count][1 << n];
        dp[0][0] = 1;
        // 帽子数
        for (int i = 1; i < count; i++) {
            // 已分配状态
            for (int j = 0; j < (1 << n); j++) {
                // 第 i 个帽子不分配的情况
                dp[i][j] = dp[i - 1][j];
                List<Integer> list = hatPersonMap.get(i);
                if (list != null) {
                    // 当前帽子可以分配的人
                    for (int person : list) {
                        if ((j & (1 << person)) == 0) {
                            // 当前状态不能分配这个人
                            continue;
                        }
                        // 将当前这个帽子分配给这个人
                        // 前 i - 1 个帽子分配的状态中没有分配给这个人的情况数
                        dp[i][j] += dp[i - 1][j - (1 << person)];
                        dp[i][j] %= MOD;
                    }
                }
            }
        }
        return dp[count - 1][(1 << n) - 1];
    }

    public static void main(String[] args) {
        Hard1434 main = new Hard1434();
        System.out.println(main.numberWays(
                Arrays.asList(
                        Arrays.asList(3, 4),
                        Arrays.asList(4, 5),
                        Collections.singletonList(5)
                )
        ));
        System.out.println(main.numberWays(
                Arrays.asList(
                        Arrays.asList(3, 5, 1),
                        Arrays.asList(3, 5)
                )
        ));
        System.out.println(main.numberWays(
                Arrays.asList(
                        Arrays.asList(1, 2, 3, 4),
                        Arrays.asList(1, 2, 3, 4),
                        Arrays.asList(1, 2, 3, 4),
                        Arrays.asList(1, 2, 3, 4)
                )
        ));
        System.out.println(main.numberWays(
                Arrays.asList(
                        Arrays.asList(1, 2, 3),
                        Arrays.asList(2, 3, 5, 6),
                        Arrays.asList(1, 3, 7, 9),
                        Arrays.asList(1, 8, 9),
                        Arrays.asList(2, 5, 7)
                )
        ));
    }
}