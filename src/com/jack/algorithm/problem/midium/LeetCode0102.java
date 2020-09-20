package com.jack.algorithm.problem.midium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author jack
 */
public class LeetCode0102 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> dataQueue = new LinkedList<>();
        TreeNode curNode;
        dataQueue.add(root);
        while (!dataQueue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = dataQueue.size();
            for (int i = 0; i < size; i++) {
                curNode = dataQueue.remove();
                list.add(curNode.val);
                TreeNode left = curNode.left;
                TreeNode right = curNode.right;
                if (left != null) {
                    dataQueue.add(left);
                }
                if (right != null) {
                    dataQueue.add(right);
                }
            }
            res.add(list);
        }
        return res;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> dataQueue = new LinkedList<>();
        Queue<Integer> depthQueue = new LinkedList<>();
        TreeNode curNode;
        int curDepth;
        dataQueue.add(root);
        depthQueue.add(0);
        while (!dataQueue.isEmpty()) {
            curNode = dataQueue.remove();
            curDepth = depthQueue.remove();
            if (res.size() <= curDepth) {
                List<Integer> list = new ArrayList<>();
                list.add(curNode.val);
                res.add(list);
            } else {
                List<Integer> list = res.get(curDepth);
                list.add(curNode.val);
            }
            TreeNode left = curNode.left;
            TreeNode right = curNode.right;
            if (left != null) {
                dataQueue.add(left);
                depthQueue.add(curDepth + 1);
            }
            if (right != null) {
                dataQueue.add(right);
                depthQueue.add(curDepth + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0102 main = new LeetCode0102();
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        node3.left = node9;
        node3.right = node20;
        node20.left = node15;
        node20.right = node7;
        System.out.println(main.levelOrder(node3));
        System.out.println(main.levelOrder2(node3));
    }
}
