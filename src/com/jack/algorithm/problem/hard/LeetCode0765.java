package com.jack.algorithm.problem.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jack
 */
public class LeetCode0765 {

    public int minSwapsCouples(int[] row) {
        int res = 0;
        for (int i = 1; i < row.length; i += 2) {
            int prePartner = row[i - 1] ^ 1;
            if (row[i] != prePartner) {
                for (int j = i + 1; j < row.length; j++) {
                    if (row[j] == prePartner) {
                        swap(row, i, j);
                        res ++;
                        break;
                    }
                }
            }
        }
        return res;
    }
    private void swap(int[] arr, int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

    public int minSwapsCouples2(int[] row) {
        int res = 0;
        Map<Integer, int[]> map =
                new HashMap<>(row.length / 2);
        for (int i = 0; i < row.length; i++) {
            int cur = row[i];
            int curPartner = row[i] ^ 1;
            if (map.containsKey(curPartner)) {
                map.get(curPartner)[1] = i;
            } else {
                int[] arr = new int[2];
                arr[0] = i;
                map.put(cur, arr);
            }
        }
        for (int i = 1; i < row.length; i += 2) {
            int pre = row[i - 1];
            int prePartner = pre ^ 1;
            if (row[i] != prePartner) {
                int[] arr;
                if (map.containsKey(pre)) {
                    arr = map.get(pre);
                } else {
                    arr = map.get(prePartner);
                }
                int toIndex;
                if (i - 1 != arr[0]) {
                    toIndex = arr[0];
                } else {
                    toIndex = arr[1];
                }
                swap(row, i, toIndex);
                // 更新 map 中对应的 新的位置
                int[] tArr;
                if (map.containsKey(row[toIndex])) {
                    tArr = map.get(row[toIndex]);
                } else {
                    tArr = map.get(row[toIndex] ^ 1);
                }
                if (tArr[0] == i) {
                    tArr[0] = toIndex;
                } else {
                    tArr[1] = toIndex;
                }
                res ++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0765 main = new LeetCode0765();
        System.out.println(main.minSwapsCouples(
                new int[] {0, 2, 1, 3}
        ));
        System.out.println(main.minSwapsCouples(
                new int[] {3, 2, 0, 1}
        ));
        System.out.println(main.minSwapsCouples2(
                new int[] {0, 2, 1, 3}
        ));
        System.out.println(main.minSwapsCouples2(
                new int[] {3, 2, 0, 1}
        ));
        System.out.println(main.minSwapsCouples2(
                new int[]{2, 0, 5, 4, 3, 1}
        ));
        System.out.println(main.minSwapsCouples2(
                new int[]{0, 2, 4, 6, 7, 1, 3, 5}
        ));
    }
}
