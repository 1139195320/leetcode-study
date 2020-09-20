package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode1049 {

    public int lastStoneWeightII(int[] stones) {
        // 将其分为两堆，使其两堆的和最接近
        // 将其分为两堆，使其和最接近总和的 1/2
        // 从总的堆里面取出一堆物品，在不大于 1/2 的情况下接近 1/2
        // 总重量为 sum
        // 背包问题：使两堆石头总重量接近 sum / 2
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        // 背包所能装载的最大石头重量
        int maxCapacity = sum / 2;
        int[] dp = new int[maxCapacity + 1];
        // 第一维是物品数量
        for (int curStone : stones) {
            // 第二维是剩余容量
            for (int j = maxCapacity; j >= curStone; j--) {
                dp[j] = Math.max(dp[j], dp[j - curStone] + curStone);
            }
        }
        // 两堆分别是 sum - dp 和 dp
        // 结果即是两堆之差 sum - dp - dp
        return sum - dp[maxCapacity] * 2;
    }

    public static void main(String[] args) {
        LeetCode1049 main = new LeetCode1049();
        System.out.println(main.lastStoneWeightII(
                new int[]{2, 7, 4, 1, 8, 1}
        ));
    }
}