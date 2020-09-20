package com.jack.algorithm.problem.hard;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author jack
 */
public class LeetCode0968 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { this.val = x; }
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(this);
            while (!queue.isEmpty()) {
                TreeNode cur = queue.remove();
                sb.append(cur.val).append(", ");
                TreeNode left = cur.left;
                TreeNode right = cur.right;
                if (left != null) {
                    queue.add(left);
                }
                if (right != null) {
                    queue.add(right);
                }
            }
            return sb.toString().substring(0, sb.length() - 2);
        }
    }

    private int[] solve(TreeNode node) {
        if (node == null) {
            return new int[] {0, 0, 99999};
        }
        int []l = solve(node.left);
        int[] r = solve(node.right);
        int ml12 = Math.min(l[1], l[2]);
        int mr12 = Math.min(r[1], r[2]);
        int d0 = l[1] + r[1];
        int d1 = Math.min(l[2] + mr12, r[2] + ml12);
        int d2 = 1 + Math.min(l[0], ml12) + Math.min(r[0], mr12);
        return new int[] {d0, d1, d2};
    }
    public int minCameraCover(TreeNode root) {
        int[] res = solve(root);
        return Math.min(res[1], res[2]);
    }



    private int res;
    private Set<TreeNode> covered;
    private void dfs(TreeNode node, TreeNode par) {
        if (node != null) {
            dfs(node.left, node);
            dfs(node.right, node);
            if (par == null && !covered.contains(node)
                    || !covered.contains(node.left)
                    || !covered.contains(node.right)) {
                res ++;
                covered.add(node);
                covered.add(par);
                covered.add(node.left);
                covered.add(node.right);
            }
        }
    }
    public int minCameraCover2(TreeNode root) {
        res = 0;
        covered = new HashSet<>();
        covered.add(null);
        dfs(root, null);
        return res;
    }

}
