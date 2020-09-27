package com.jack.algorithm.problem.midium;

import java.util.*;

/**
 * @author jack
 */
public class LeetCode0199 {

    private static class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        TreeNode curNode = root;
        int depth = 0;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> depthQueue = new LinkedList<>();
        nodeQueue.add(curNode);
        depthQueue.add(depth);
        int maxDepth = -1;
        // 深度：最右边的值
        Map<Integer, Integer> map = new HashMap<>();
        while (!nodeQueue.isEmpty()) {
            curNode = nodeQueue.remove();
            depth = depthQueue.remove();
            if (curNode != null) {
                maxDepth = Math.max(maxDepth, depth);
                map.put(depth, curNode.val);
                TreeNode left = curNode.left;
                TreeNode right = curNode.right;
                if (left != null) {
                    nodeQueue.add(left);
                    depthQueue.add(depth + 1);
                }
                if (right != null) {
                    nodeQueue.add(right);
                    depthQueue.add(depth + 1);
                }
            }
        }
        for (int i = 0; i <= maxDepth; i++) {
            list.add(map.get(i));
        }
        return list;
    }

    public static void main(String[] args) {
        LeetCode0199 main = new LeetCode0199();
        System.out.println(main.rightSideView(getRoot1()));
        System.out.println(main.rightSideView(getRoot2()));
        System.out.println(main.rightSideView(getRoot3()));
    }

    private static TreeNode getRoot3() {
        TreeNode root = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        root.left = node1;
        node1.right = node3;
        node3.left = node2;
        node3.right = node5;
        node5.left = node4;
        return root;
    }

    private static TreeNode getRoot2() {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        return root;
    }

    private static TreeNode getRoot1() {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        root.left = node2;
        root.right = node3;
        node2.right = node5;
        node3.right = node4;
        return root;
    }
}
