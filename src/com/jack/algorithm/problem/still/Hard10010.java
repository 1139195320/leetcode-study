package com.jack.algorithm.problem.still;

/**
 * @author jack
 */
public class Hard10010 {

    public static void main(String[] args) {
        Hard10010 main = new Hard10010();
        TreeNode root = main.getNode(new Integer[] {
                47, 74, 31
        });
        System.out.println(main.minimalExecTime(root));
        System.out.println(main.minimalExecTime2(root));
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { this.val = x; }
    }
    private TreeNode getNode(Integer[] arr) {
        if (arr == null) {
            return null;
        }
        return doGetNode(arr, 0);
    }
    private TreeNode doGetNode(Integer[] arr, int i) {
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

    public double minimalExecTime(TreeNode root) {
        double[] res = dfs(root);
        return res[0] - res[1];
    }
    private double[] dfs(TreeNode node) {
        if (node == null) {
            return new double[] {0, 0};
        }
        double tc = node.val;
        // 先递归左右子树
        double[] resLeft = dfs(node.left);
        double[] resRight = dfs(node.right);
        tc += resLeft[0] + resRight[0];
        if (resLeft[0] < resRight[0]) {
            // 只考虑 a >= c 的情况，不满足就交换
            double tmp = resLeft[0];
            resLeft[0] = resRight[0];
            resRight[0] = tmp;
            tmp = resLeft[1];
            resLeft[1] = resRight[1];
            resRight[1] = tmp;
        }
        double pc;
        if (resLeft[0] - resLeft[1] * 2 <= resRight[0]) {
            pc = (resLeft[0] + resRight[0]) / 2;
        } else {
            pc = resRight[0] + resLeft[1];
        }
        return new double[] {tc, pc};
    }



    public double minimalExecTime2(TreeNode root) {
        return dfs2(root)[1];
    }
    private double[] dfs2(TreeNode node) {
        if (node == null) {
            return new double[] {0, 0};
        }
        // 先递归左右子树
        double[] resLeft = dfs2(node.left);
        double[] resRight = dfs2(node.right);
        return new double[] {
                resLeft[0] + resRight[0] + node.val,
                node.val + Math.max(Math.max(resLeft[1], resRight[1]),
                        (resLeft[0] + resRight[0]) / 2.0)
        };
    }

}