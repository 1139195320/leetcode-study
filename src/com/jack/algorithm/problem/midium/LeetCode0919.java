package com.jack.algorithm.problem.midium;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jack
 */
public class LeetCode0919 {

    private static TreeNode getNode(Integer[] arr) {
        if (arr == null) {
            return null;
        }
        return doGetNode(arr, 0);
    }
    private static TreeNode doGetNode(Integer[] arr, int i) {
        if (i >= arr.length) {
            return null;
        }
        Integer data = arr[i];
        if (data == null) {
            return null;
        }
        TreeNode node = new TreeNode(data);
        node.left = doGetNode(arr, (i << 1) + 1);
        node.right = doGetNode(arr, (i << 1) + 2);
        return node;
    }

    public static void main(String[] args) {
        CBTInserter main = new CBTInserter(getNode(
                new Integer[] {1, 3, 5, 7}));
        System.out.println(main.insert(8));
        System.out.println(main.insert(9));
        System.out.println(main.insert(6));
        System.out.println(main.insert(2));
        System.out.println(main.get_root());
    }
}

class TreeNode {
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

class CBTInserter {
    private TreeNode root;
    private Deque<TreeNode> deque;

    public CBTInserter(TreeNode root) {
        this.root = root;
        deque = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur != null) {
                TreeNode left = cur.left;
                TreeNode right = cur.right;
                if (left == null || right == null) {
                    // 把有子节点空位的节点从右往左存入队列
                    deque.offerLast(cur);
                }
                if (left != null) {
                    queue.offer(left);
                }
                if (right != null) {
                    queue.offer(right);
                }
            }
        }
    }

    public int insert(int v) {
        // 从左往右取出有子节点空位的节点
        TreeNode node = deque.peekFirst();
        deque.offerLast(new TreeNode(v));
        if (node.left == null) {
            // 有左子节点空位（说明也有右子节点空位）
            node.left = deque.peekLast();
        } else {
            // 只有右子节点空位
            node.right = deque.peekLast();
            // 已填充右子节点，此节点无子节点空位，移出队列
            deque.pollFirst();
        }
        return node.val;
    }

    public TreeNode get_root() {
        return root;
    }
}