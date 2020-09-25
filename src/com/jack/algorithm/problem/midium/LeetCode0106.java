package com.jack.algorithm.problem.midium;

import java.util.*;

/**
 * @author jack
 */
public class LeetCode0106 {

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

    private Map<Integer, Integer> inMap;
    private int[] postOrder;
    private TreeNode doBuildTree(int lPost, int rPost, int lIn, int rIn) {
        if (lPost > rPost) {
            return null;
        }
        int inRootIndex = inMap.get(postOrder[rPost]);
        TreeNode root = new TreeNode(postOrder[rPost]);
        int leftSize = inRootIndex - lIn;
        root.left = doBuildTree(lPost, lPost + leftSize - 1, lIn, inRootIndex - 1);
        root.right = doBuildTree(lPost + leftSize, rPost - 1, inRootIndex + 1, rIn);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postOrder = postorder;
        inMap = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return doBuildTree(0, postorder.length - 1, 0, inorder.length - 1);
    }

    public static void main(String[] args) {
        // 3
        // 9 20
        // n n 15 7
        LeetCode0106 main = new LeetCode0106();
        TreeNode node = main.buildTree(
                new int[]{9, 3, 15, 20, 7},
                new int[]{9, 15, 7, 20, 3}
        );
        System.out.println(node);
    }

}
