package com.jack.algorithm.problem.easy;

/**
 * @author fy
 */
public class LeetCode0235 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int pVal = p.val;
        int qVal = q.val;
        if (pVal < qVal) {
            return findLowestCommonAncestor(root, pVal, qVal);
        } else {
            return findLowestCommonAncestor(root, qVal, pVal);
        }
    }
    private TreeNode findLowestCommonAncestor(TreeNode node, int min, int max) {
        if (node == null) {
            return null;
        }
        int cur = node.val;
        if (max < cur) {
            // 说明两个都在 node 的左边
            return findLowestCommonAncestor(node.left, min, max);
        } else if (min > cur) {
            // 说明两个都在 node 的右边
            return findLowestCommonAncestor(node.right, min, max);
        }
        // 说明一左一右
        // 或者有一个和当前相等，另一个是子
        return node;
    }

}
