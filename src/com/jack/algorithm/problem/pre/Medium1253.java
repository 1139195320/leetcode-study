package com.jack.algorithm.problem.pre;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jack
 */
public class Medium1253 {

    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> aList = new ArrayList<>();
        List<Integer> bList = new ArrayList<>();
        // 统计 2 的数目
        int count2 = 0;
        for (int cur : colsum) {
            if (cur == 2) {
                count2++;
            }
        }
        for (int cur : colsum) {
            if (cur == 2) {
                aList.add(1);
                bList.add(1);
            } else if (cur == 0) {
                aList.add(0);
                bList.add(0);
            } else {
                if (upper > count2) {
                    aList.add(1);
                    bList.add(0);
                    upper--;
                } else if (lower > count2) {
                    aList.add(0);
                    bList.add(1);
                    lower--;
                } else {
                    return new ArrayList<>();
                }
            }
        }
        res.add(aList);
        res.add(bList);
        return res;
    }

    public static void main(String[] args) {
        Medium1253 main = new Medium1253();
        System.out.println(main.reconstructMatrix(
                2, 1, new int[]{1, 1, 1}
        ));
        System.out.println(main.reconstructMatrix(
                2, 3, new int[]{2, 2, 1, 1}
        ));
        System.out.println(main.reconstructMatrix(
                5, 5, new int[]{2, 1, 2, 0, 1, 0, 1, 2, 0, 1}
        ));
    }
}