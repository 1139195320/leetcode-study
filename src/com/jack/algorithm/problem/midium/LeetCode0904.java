package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0904 {

    public int totalFruit(int[] tree) {
        int res = 0;
        // 记录选的第一个 type 的位置
        int firstIndex = 0;
        // 记录选的第一个 type
        int firstType = tree[0];
        // 记录选的第二个 type
        int secondType = tree[0];
        // 当前是否有两个 type
        boolean flag = false;
        int n = tree.length;
        int curIndex = 0;
        // 记录路径上上一个 type
        int preType = tree[0];
        // 记录路径上上一个 type 的位置
        int preIndex = 0;
        while (curIndex < n) {
            if (tree[curIndex] == firstType) {
                // 当前 type 为选的第一个 type
                res = Math.max(res, curIndex - firstIndex + 1);
            }
            else {
                if (!flag) {
                    // 当前选了一个 type，继续选
                    secondType = tree[curIndex];
                    res = Math.max(res, curIndex - firstIndex + 1);
                    flag = true;
                }
                else {
                    // 当前已经选了两个 type
                    // 且当前 type 不是选的第一个 type
                    if (tree[curIndex] == secondType) {
                        // 当前 type 为选的第二个 type
                        res = Math.max(res, curIndex - firstIndex + 1);
                    }
                    else {
                        // 当前 type 不是选的第二个 type
                        // 将第二个 type 作为第一个 type，当前 type 作为第二个 type
                        firstIndex = preIndex;
                        firstType = preType;
                        secondType = tree[curIndex];
                    }
                }
            }
            if (tree[curIndex] != preType) {
                preType = tree[curIndex];
                preIndex = curIndex;
            }
            curIndex ++;
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0904 main = new LeetCode0904();
        System.out.println(main.totalFruit(
                new int[]{1, 2, 1}
        ));
        System.out.println(main.totalFruit(
                new int[]{0, 1, 2, 2}
        ));
        System.out.println(main.totalFruit(
                new int[]{1, 2, 3, 2, 2}
        ));
        System.out.println(main.totalFruit(
                new int[]{1, 2, 1, 1, 2, 3, 3, 4}
        ));
    }
}