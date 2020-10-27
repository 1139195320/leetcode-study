package com.jack.algorithm.problem.midium;

import java.util.*;

/**
 * @author jack
 */
public class LeetCode0144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        // 前序 -> 中-左-右
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.remove();
            if (cur == null) {
                res.add(null);
            } else {
                res.add(cur.val);
                queue.add(cur.left);
                queue.add(cur.right);
            }
        }
        return res;
    }
}
