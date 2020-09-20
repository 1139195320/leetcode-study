package com.jack.algorithm.problem.hard;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jack
 *
 * 官方解答
 */
public class LeetCode029702 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { this.val = x; }
    }

    public String doSerialize(TreeNode root, String str) {
        if (root == null) {
            str += "null,";
        } else {
            str += root.val + ",";
            str = doSerialize(root.left, str);
            str = doSerialize(root.right, str);
        }
        return str;
    }

    public String serialize(TreeNode root) {
        return doSerialize(root, "");
    }

    public TreeNode doDeserialize(List<String> list) {
        if ("null".equals(list.get(0))) {
            list.remove(0);
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);
        root.left = doDeserialize(list);
        root.right = doDeserialize(list);
        return root;
    }
    public TreeNode deserialize(String data) {
        String[] strArr = data.split(",");
        return doDeserialize(new LinkedList<>(Arrays.asList(strArr)));
    }

    public static void main(String[] args) {
        LeetCode029702 main = new LeetCode029702();
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        node1.left = new TreeNode(2);
        node1.right = node3;
        node3.left = new TreeNode(4);
        node3.right = new TreeNode(5);
        System.out.println(main.serialize(node1));
        System.out.println(main.serialize(main.deserialize(main.serialize(node1))));
    }
}
