package com.jack.algorithm.problem.midium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jack
 */
public class LeetCode0113 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { this.val = x; }
    }

    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        pathSum(root, 0, sum, new ArrayList<>());
        return res;
    }
    private void pathSum(TreeNode node, int pre, int target,
                         List<Integer> path) {
        if (node == null) {
            return;
        }
        path.add(node.val);
        int cur = pre + node.val;
        if (cur == target && node.left == null && node.right == null) {
            res.add(path);
            return;
        }
        pathSum(node.left, cur, target, new ArrayList<>(path));
        pathSum(node.right, cur, target, new ArrayList<>(path));
    }

    private void pathSum2(TreeNode node, int pre, int target,
                         List<Integer> path) {
        if (node == null) {
            return;
        }
        path.add(node.val);
        int cur = pre + node.val;
        if (node.left == null && node.right == null) {
            if (cur == target) {
                res.add(new ArrayList<>(path));
            }
        } else {
            pathSum2(node.left, cur, target, path);
            pathSum2(node.right, cur, target, path);
        }
        path.remove(path.size() - 1);
    }
}
