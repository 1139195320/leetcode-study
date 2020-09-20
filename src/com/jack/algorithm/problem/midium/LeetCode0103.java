package com.jack.algorithm.problem.midium;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jack
 * 二叉树的锯齿形层次遍历
 */
public class LeetCode0103 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { this.val = x; }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        boolean flag = true;
        if (root != null) {
            deque.add(root);
        }
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> list = new ArrayList<>();
            if (flag) {
                for (int i = 0; i < size; i++) {
                    TreeNode cur = deque.removeFirst();
                    list.add(cur.val);
                    if (cur.left != null) {
                        deque.add(cur.left);
                    }
                    if (cur.right != null) {
                        deque.add(cur.right);
                    }
                }
                flag = false;
            } else {
                for (int i = 0; i < size; i++) {
                    TreeNode cur = deque.removeLast();
                    list.add(cur.val);
                    if (cur.right != null) {
                        deque.addFirst(cur.right);
                    }
                    if (cur.left != null) {
                        deque.addFirst(cur.left);
                    }
                }
                flag = true;
            }
            res.add(list);
        }
        return res;
    }
}
