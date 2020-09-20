package com.jack.algorithm.problem.easy;

import java.util.*;

/**
 * @author jack
 */
public class LeetCode0107 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Stack<List<Integer>> resStack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.remove();
                list.add(curNode.val);
                TreeNode left = curNode.left;
                TreeNode right = curNode.right;
                if (left != null) {
                    queue.add(left);
                }
                if (right != null) {
                    queue.add(right);
                }
            }
            resStack.add(list);
        }
        while (!resStack.empty()) {
            res.add(resStack.pop());
        }
        return res;
    }
}
