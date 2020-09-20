package com.jack.algorithm.problem.midium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author jack
 */
public class LeetCode0662 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { this.val = x; }
    }

    public int widthOfBinaryTree2(TreeNode root) {
        res = 0;
        leftMap = new HashMap<>();
        dfs(root, 0, 0);
        return res;
    }
    private int res;
    private Map<Integer, Integer> leftMap;
    private void dfs(TreeNode root, int depth, int pos) {
        if (root == null) {
            return;
        }
        leftMap.computeIfAbsent(depth, x -> pos);
        res = Math.max(res, pos - leftMap.get(depth) + 1);
        dfs(root.left, depth + 1, pos * 2);
        dfs(root.right, depth + 1, pos * 2 + 1);
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            boolean allNull = true;
            int size = queue.size();
            int start = -1;
            int end = 0;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.remove();
                if (cur != null) {
                    allNull = false;
                    if (start == -1) {
                        start = i;
                    }
                    end = i;
                    queue.add(cur.left);
                    queue.add(cur.right);
                } else {
                    queue.add(null);
                    queue.add(null);
                }
            }
            if (allNull) {
                break;
            }
            res = Math.max(res, end - start + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0662 main = new LeetCode0662();
        System.out.println(main.widthOfBinaryTree(getTestNode1()));
        System.out.println(main.widthOfBinaryTree(getTestNode2()));
        System.out.println(main.widthOfBinaryTree(getTestNode3()));
        System.out.println(main.widthOfBinaryTree(getTestNode4()));
    }

    private static TreeNode getTestNode1() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node3;
        node1.right = node2;
        node3.left = new TreeNode(5);
        node3.right = new TreeNode(3);
        node2.right = new TreeNode(9);
        return node1;
    }
    private static TreeNode getTestNode2() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        node1.left = node3;
        node3.left = new TreeNode(5);
        node3.right = new TreeNode(3);
        return node1;
    }
    private static TreeNode getTestNode3() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node3;
        node1.right = node2;
        node3.left = new TreeNode(5);
        return node1;
    }
    private static TreeNode getTestNode4() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node9 = new TreeNode(9);
        node1.left = node3;
        node1.right = node2;
        node3.left = node5;
        node2.right = node9;
        node5.left = new TreeNode(6);
        node9.right = new TreeNode(7);
        return node1;
    }
}