package com.jack.algorithm.problem.midium;

import java.util.*;

/**
 * @author jack
 */
public class LeetCode0144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        // 前序 -> 中-左-右
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while (!stack.empty() || root != null) {
            while (root != null) {
                list.add(root.val);
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return list;
    }
}
