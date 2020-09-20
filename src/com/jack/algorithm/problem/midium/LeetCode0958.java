package com.jack.algorithm.problem.midium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author jack
 *
 * false :
 * 1、前一深度有 null 节点，当前深度有非 null 节点
 * 2、同一深度，null 节点的后面有非 null 节点
 *
 */
public class LeetCode0958 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { this.val = x; }
    }

    public boolean isCompleteTree(TreeNode root) {
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            // 当前深度的前一深度是否有 null 节点
            boolean preHasNull = false;
            while (!queue.isEmpty()) {
                // 当前深度现在有没有出现 null 节点
                boolean hasNull = false;
                // 当前深度是不是全部 null 节点
                boolean allNull = true;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue.remove();
                    if (cur == null) {
                        // 当前深度现在出现了 null 节点
                        hasNull = true;
                        continue;
                    }
                    if (hasNull) {
                        // 当前节点不是 null，但是前面已有节点是 null
                        System.out.println("同一深度，null 节点的后面有非 null 节点");
                        return false;
                    }
                    allNull = false;
                    TreeNode left = cur.left;
                    TreeNode right = cur.right;
                    queue.add(left);
                    queue.add(right);
                }
                if (allNull) {
                    break;
                } else {
                    if (preHasNull) {
                        System.out.println("前一深度有 null 节点，当前深度有非 null 节点");
                        return false;
                    }
                }
                preHasNull = hasNull;
            }
        }
        return true;
    }

    private static class ANode {
        TreeNode node;
        // 编号
        int code;
        ANode(TreeNode node, int code) {
            this.node = node;
            this.code = code;
        }
    }
    public boolean isCompleteTree2(TreeNode root) {
        List<ANode> list = new ArrayList<>();
        list.add(new ANode(root, 1));
        int i = 0;
        while (i < list.size()) {
            ANode aNode = list.get(i ++);
            TreeNode node = aNode.node;
            if (node != null) {
                int code = aNode.code;
                list.add(new ANode(node.left, code * 2));
                list.add(new ANode(node.right, code * 2 + 1));
            }
        }
        return list.get(i - 1).code == list.size();
    }

    public static void main(String[] args) {
        LeetCode0958 main = new LeetCode0958();
        System.out.println(main.isCompleteTree(getTestNode1()));
        System.out.println(main.isCompleteTree(getTestNode2()));
        System.out.println(main.isCompleteTree(getTestNode3()));
        System.out.println(main.isCompleteTree(getTestNode4()));
        System.out.println("=================");
        System.out.println(main.isCompleteTree2(getTestNode1()));
        System.out.println(main.isCompleteTree2(getTestNode2()));
        System.out.println(main.isCompleteTree2(getTestNode3()));
        System.out.println(main.isCompleteTree2(getTestNode4()));
    }
    private static TreeNode getTestNode1() {
        // 1
        // 2 3
        // 4 5 6 null
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        return node1;
    }
    private static TreeNode getTestNode2() {
        // 1
        // 2 3
        // 4 5 null 7
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node7;
        return node1;
    }
    private static TreeNode getTestNode3() {
        // 1
        // 2 3
        // 4 5 6 null
        // 7
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node4.left = node7;
        return node1;
    }
    private static TreeNode getTestNode4() {
        // 1
        // 2 3
        // 4 5 6 null
        // null 7
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node4.right = node7;
        return node1;
    }
}