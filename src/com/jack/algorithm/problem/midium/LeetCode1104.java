package com.jack.algorithm.problem.midium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author jack
 */
public class LeetCode1104 {

    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> list = new ArrayList<>();
        list.add(label);
        // 先求出当前数所在行数
        int row = 1;
        while ((label >>= 1) > 0) {
            row ++;
        }
        findParTree(list, row);
        Collections.reverse(list);
        return list;
    }
    private void findParTree(List<Integer> list, int row) {
        if (row == 1) {
            return;
        }
        // 当前数
        int curNum = list.get(list.size() - 1);
        // 当前这行的节点总数，也是当前这行的最小值
        int minForRow = 2 << (row - 2);
        // 偶数行从右往左
        // 奇数行从左往右
        // 但是奇数还是偶数行不影响下面的逻辑
        // 当前这个数和当前最小数的距离
        int len = curNum - minForRow;
        // 求出该节点的父节点值
        int parNum = minForRow - ((len >> 1) + 1);
        list.add(parNum);
        findParTree(list, row - 1);
    }

    public static void main(String[] args) {
        LeetCode1104 main = new LeetCode1104();
        System.out.println(main.pathInZigZagTree(26));
        System.out.println(main.pathInZigZagTree(14));
    }
}
