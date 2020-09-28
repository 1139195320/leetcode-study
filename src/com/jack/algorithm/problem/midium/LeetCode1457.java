package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode1457 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { this.val = x; }
    }
    private int res;
    public int pseudoPalindromicPaths (TreeNode root) {
        res = 0;
        dfs(root, 0);
        return res;
    }
    private void dfs(TreeNode node, int path) {
        if (node == null) {
            return;
        }
        TreeNode left = node.left;
        TreeNode right = node.right;
        path ^= (1 << node.val);
        if (left == null && right == null) {
//            if (Integer.bitCount(path) <= 1) {
            if (path == 0 || (path & (path - 1)) == 0) {
                res ++;
            }
            return;
        }
        dfs(left, path);
        dfs(right, path);
    }
}
