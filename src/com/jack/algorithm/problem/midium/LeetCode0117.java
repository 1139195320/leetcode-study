package com.jack.algorithm.problem.midium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jack
 */
public class LeetCode0117 {

    private static class Node {
        int val;
        Node left;
        Node right;
        Node next;
        Node(int x) { this.val = x; }
    }

    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.remove();
                if (i != size - 1) {
                    cur.next = queue.peek();
                }
                Node left = cur.left;
                Node right = cur.right;
                if (left != null) {
                    queue.add(left);
                }
                if (right != null) {
                    queue.add(right);
                }
            }
        }
        return root;
    }

}
