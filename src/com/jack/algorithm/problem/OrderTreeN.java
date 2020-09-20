package com.jack.algorithm.problem;

import java.util.*;

/**
 * @author jack
 */
public class OrderTreeN {

    private static class Node {
        int val;
        List<Node> children;
        Node(int x) { this.val = x; }
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.remove();
                list.add(cur.val);
                List<Node> childNodes = cur.children;
                if (childNodes != null) {
                    queue.addAll(childNodes);
                }
            }
            res.add(list);
        }
        return res;
    }

    public List<Integer> preOrder(Node root) {
        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.empty()) {
            Node cur = stack.pop();
            res.add(cur.val);
            List<Node> childNodes = cur.children;
            if (childNodes != null) {
                for (int i = childNodes.size() - 1; i >= 0; i--) {
                    stack.push(childNodes.get(i));
                }
            }
        }
        return res;
    }

    public List<Integer> postOrder(Node root) {
        List<Integer> res = new ArrayList<>();
        doPostOrder(root, res);
        return res;
    }
    private void doPostOrder(Node node, List<Integer> res) {
        if (node != null) {
            List<Node> childNodes = node.children;
            if (childNodes != null) {
                for (Node childNode : childNodes) {
                    doPostOrder(childNode, res);
                }
            }
            res.add(node.val);
        }
    }
}