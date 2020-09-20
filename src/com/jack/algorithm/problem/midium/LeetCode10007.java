package com.jack.algorithm.problem.midium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jack
 */
public class LeetCode10007 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { this.val = x; }
    }


    private TreeNode buildTree(int[] preorder, int[] inorder,
                              int lPre, int rPre, int lIn, int rIn) {
        if (lPre > rPre) {
            return null;
        }
        int inRootIndex = inorderMap.get(preorder[lPre]);
        // 左边节点个数
        int lSize = inRootIndex - lIn;
        TreeNode root = new TreeNode(preorder[lPre]);
        // build left
        root.left = buildTree(preorder, inorder,
                lPre + 1, lPre + lSize,
                inRootIndex - lSize, inRootIndex - 1);
        // build right
        root.right = buildTree(preorder, inorder,
                lPre + lSize + 1, rPre,
                inRootIndex + 1, rIn);
        return root;
    }
    private Map<Integer, Integer> inorderMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null
                || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        inorderMap = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTree(preorder, inorder,
                0, preorder.length - 1, 0, inorder.length - 1);
    }
}
