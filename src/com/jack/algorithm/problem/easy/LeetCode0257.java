package com.jack.algorithm.problem.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jack
 */
public class LeetCode0257 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { this.val = x; }
    }

    private List<String> res;
    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();
        dfs(root, "");
        return res;
    }
    private void dfs(TreeNode node, String cur) {
        if (node == null) {
            return;
        }
        TreeNode left = node.left;
        TreeNode right = node.right;
        if (cur.length() > 0) {
            cur += "->";
        }
        cur += node.val;
        if (left == null && right == null) {
            res.add(cur);
        }
        dfs(left, cur);
        dfs(right, cur);
    }

    public static void main(String[] args) {
        LeetCode0257 main = new LeetCode0257();
    }

}