package com.jack.algorithm.problem.midium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author jack
 * 在一个 m*n 的二维字符串数组中输出二叉树，并遵守以下规则：
 *
 * 行数 m 应当等于给定二叉树的高度。
 * 列数 n 应当总是奇数。
 * 根节点的值（以字符串格式给出）应当放在可放置的第一行正中间。根节点所在的行与列会将剩余空间划分为两部分（左下部分和右下部分）。你应该将左子树输出在左下部分，右子树输出在右下部分。左下和右下部分应当有相同的大小。即使一个子树为空而另一个非空，你不需要为空的子树输出任何东西，但仍需要为另一个子树留出足够的空间。然而，如果两个子树都为空则不需要为它们留出任何空间。
 * 每个未使用的空间应包含一个空的字符串""。
 * 使用相同的规则输出子树。
 * 示例 1:
 *
 * 输入:
 *      1
 *     /
 *    2
 * 输出:
 * [["", "1", ""],
 *  ["2", "", ""]]
 * 示例 2:
 *
 * 输入:
 *      1
 *     / \
 *    2   3
 *     \
 *      4
 * 输出:
 * [["", "", "", "1", "", "", ""],
 *  ["", "2", "", "", "", "3", ""],
 *  ["", "", "4", "", "", "", ""]]
 * 示例 3:
 *
 * 输入:
 *       1
 *      / \
 *     2   5
 *    /
 *   3
 *  /
 * 4
 * 输出:
 * [["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
 *  ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
 *  ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
 *  ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
 * 注意: 二叉树的高度在范围 [1, 10] 中。
 *
 */
public class LeetCode0655 {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    private int getSpaceNum(int size, int depth) {
        int res = 0;
        for (int i = 0; i < (size - depth); i++) {
            res = res * 2 + 1;
        }
        return res;
    }
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<List<String>> resQueue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // 这一行全是 null
            boolean isNull = true;
            int size = queue.size();
            List<String> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.remove();
                if (cur == null) {
                    queue.add(null);
                    queue.add(null);
                    list.add("");
                } else {
                    isNull = false;
                    queue.add(cur.left);
                    queue.add(cur.right);
                    list.add(String.valueOf(cur.val));
                }
            }
            if (isNull) {
                break;
            }
            resQueue.add(list);
        }
        int size = resQueue.size();
        for (int i = 0; i < size; i++) {
            List<String> newCur = new ArrayList<>();
            List<String> cur = resQueue.remove();
            int num = getSpaceNum(size, i + 1);
            List<String> mSpaceList = new ArrayList<>();
            for (int j = 0; j < (num * 2 + 1); j++) {
                mSpaceList.add("");
            }
            for (int j = 0; j < cur.size(); j++) {
                newCur.add(cur.get(j));
                if (j != cur.size() - 1) {
                    newCur.addAll(mSpaceList);
                }
            }
            for (int j = 0; j < num; j++) {
                newCur.add(0, "");
                newCur.add("");
            }
            res.add(newCur);
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0655 main = new LeetCode0655();
        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(2);
        System.out.println(main.printTree(node1));
    }
}
