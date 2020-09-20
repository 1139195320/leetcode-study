package com.jack.algorithm.problem.midium;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author jack
 */
public class LeetCode0105 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { this.val = x; }
    }

    private Map<Integer, Integer> inMap;
    private int[] preorder;
    private TreeNode doBuildTree(int lPre, int rPre, int lIn, int rIn) {
        if (lPre > rPre) {
            return null;
        }
        int inRootIndex = inMap.get(preorder[lPre]);
        TreeNode root = new TreeNode(preorder[lPre]);
        int leftSize = inRootIndex - lIn;
        root.left = doBuildTree(lPre + 1, lPre + leftSize, lIn, inRootIndex - 1);
        root.right = doBuildTree(lPre + leftSize + 1, rPre, inRootIndex + 1, rIn);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        inMap = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return doBuildTree(0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preVal);
                stack.push(node.left);
            } else {
                while (!stack.empty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex ++;
                }
                node.right = new TreeNode(preVal);
                stack.push(node.right);
            }
        }
        return root;
    }
}
