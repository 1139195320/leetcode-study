package com.jack.algorithm.problem.midium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jack
 */
public class LeetCode0337 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {this.val = val;}
    }

    public int rob(TreeNode root) {
        return rob1(root);
    }

    public int rob1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int money = root.val;
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left != null) {
            money += rob1(left.left) + rob1(left.right);
        }
        if (right != null) {
            money += rob1(right.left) + rob1(right.right);
        }
        return Math.max(money, rob1(root.left) + rob1(root.right));
    }

    private Map<TreeNode, Integer> mono = new HashMap<>();
    public int rob2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (mono.containsKey(root)) {
            return mono.get(root);
        }
        int money = root.val;
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (left != null) {
            money += rob2(left.left) + rob2(left.right);
        }
        if (right != null) {
            money += rob2(right.left) + rob2(right.right);
        }
        money = Math.max(money, rob2(root.left) + rob2(root.right));
        mono.put(root, money);
        return money;
    }

    public int rob3(TreeNode root) {
        int[] res = doRob3(root);
        return Math.max(res[0], res[1]);
    }
    private int[] doRob3(TreeNode curNode) {
        // 返回 没选 curNode 和 选了 curNode 的两个最大结果
        if (curNode == null) {
            return new int[2];
        }
        int[] left = doRob3(curNode.left);
        int[] right = doRob3(curNode.right);
        int[] res = new int[2];
        // 当前节点不选，子节点可选可不选
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 当前节点选了，子节点不可选
        res[1] = curNode.val + left[0] + right[0];
        return res;
    }

}
