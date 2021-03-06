package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0236 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            // 找到了 p 或 q
            return root;
        }
        // 递归 left 里面去找 p、q
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        // 递归 right 里面去找 p、q
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            // left 里面没有 p 和 q，说明 p、q 都在 right 中
            return right;
        }
        if (right == null) {
            // right 里面没有 p 和 q，说明 p、q 都在 left 中
            return left;
        }
        // left 里面找到了一个，right 里面找到了一个
        return root;
    }

    public static void main(String[] args) {
        LeetCode0236 main = new LeetCode0236();
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);
        node3.left = node5;
        node3.right = node1;
        node5.left = node6;
        node5.right = node2;
        node1.left = node0;
        node1.right = node8;
        node2.left = node7;
        node2.right = node4;
        System.out.println(main.lowestCommonAncestor(node3, node5, node1));
        System.out.println(main.lowestCommonAncestor(node3, node5, node4));
    }
}
