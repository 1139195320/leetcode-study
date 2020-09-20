package com.jack.algorithm.problem.pre;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author jack
 */
public class Medium1424 {

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int allSize = 0;
        for (List<Integer> num : nums) {
            allSize += num.size();
        }
        // 从第几行开始取
        int row = 0;
        // 该行从 pos 位开始取
        int[] pos = new int[nums.size()];
        int[] res = new int[allSize];
        int i = 0;
        while (i < allSize) {
            for (int j = row; j >= 0; j--) {
                List<Integer> cur = nums.get(j);
                if (pos[j] == cur.size()) {
                    // 这一行已经取完了
                    continue;
                }
                res[i ++] = cur.get(pos[j]);
                pos[j] ++;
            }
            if (row < nums.size() - 1) {
                row ++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Medium1424 main = new Medium1424();
        System.out.println(Arrays.toString(main.findDiagonalOrder(
                Arrays.asList(
                        Arrays.asList(1, 2, 3, 4, 5),
                        Arrays.asList(6, 7),
                        Collections.singletonList(8),
                        Arrays.asList(9, 10, 11),
                        Arrays.asList(12, 13, 14, 15, 16)
                )
        )));
        System.out.println(Arrays.toString(main.findDiagonalOrder(
                Arrays.asList(
                        Arrays.asList(1, 2, 3),
                        Collections.singletonList(4),
                        Arrays.asList(5, 6, 7),
                        Collections.singletonList(8),
                        Arrays.asList(9, 10, 11)
                )
        )));
        System.out.println(Arrays.toString(main.findDiagonalOrder(
                Collections.singletonList(
                        Arrays.asList(1, 2, 3, 4, 5, 6)
                )
        )));
    }
}