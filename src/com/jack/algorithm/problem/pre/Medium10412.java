package com.jack.algorithm.problem.pre;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jack
 */
public class Medium10412 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    public int pathSum(TreeNode root, int sum) {
        // key是前缀和, value是大小为key的前缀和出现的次数
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        // 前缀和为0的一条路径
        prefixSumCount.put(0, 1);
        // 前缀和的递归回溯思路
        return recursionPathSum(root, prefixSumCount, sum, 0);
    }

    private int recursionPathSum(TreeNode node, Map<Integer, Integer> prefixSumCount,
                                 int target, int curSum) {
        // 1.递归终止条件
        if (node == null) {
            return 0;
        }
        // 2.本层要做的事情
        int res = 0;
        // 当前路径上的和
        curSum += node.val;

        res += prefixSumCount.getOrDefault(curSum - target, 0);
        // 更新路径上当前节点前缀和的个数
        prefixSumCount.put(curSum,
                prefixSumCount.getOrDefault(curSum, 0) + 1);
        // 3.进入下一层
        res += recursionPathSum(node.left, prefixSumCount, target, curSum);
        res += recursionPathSum(node.right, prefixSumCount, target, curSum);

        // 4.回到本层，恢复状态，去除当前节点的前缀和数量
        prefixSumCount.put(curSum, prefixSumCount.get(curSum) - 1);
        return res;
    }


    public static void main(String[] args) {
        Medium10412 main = new Medium10412();
    }
}