package com.jack.algorithm.problem.midium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jack
 */
public class LeetCode1222 {

    private List<List<Integer>> res;
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        // 上 -> 右上 -> 右 -> ... 顺时针 1-8
        int isVisited = 0;
        // i 方向的坐标，对应 8 个方向
        int[][] visited = new int[8][2];
        res = new ArrayList<>();
        for (int[] queen : queens) {
            int x = queen[0];
            int y = queen[1];
            if (x == king[0]) {
                if (y > king[1]) {
                    // 右
                    int tmp = 1 << 2;
                    if ((isVisited & tmp) == 0) {
                        // 还没有
                        visited[2][0] = x;
                        visited[2][1] = y;
                        isVisited += tmp;
                    } else {
                        visited[2][1] = Math.min(visited[2][1], y);
                    }
                }
                if (y < king[1]) {
                    // 左
                    int tmp = 1 << 6;
                    if ((isVisited & tmp) == 0) {
                        // 还没有
                        visited[6][0] = x;
                        visited[6][1] = y;
                        isVisited += tmp;
                    } else {
                        visited[6][1] = Math.max(visited[6][1], y);
                    }
                }
            }
            else if (y == king[1]) {
                if (x < king[0]) {
                    // 上
                    int tmp = 1 << 0;
                    if ((isVisited & tmp) == 0) {
                        // 还没有
                        visited[0][0] = x;
                        visited[0][1] = y;
                        isVisited += tmp;
                    } else {
                        visited[0][0] = Math.max(visited[0][0], x);
                    }
                }
                if (x > king[0]) {
                    // 下
                    int tmp = 1 << 4;
                    if ((isVisited & tmp) == 0) {
                        // 还没有
                        visited[4][0] = x;
                        visited[4][1] = y;
                        isVisited += tmp;
                    } else {
                        visited[4][0] = Math.min(visited[4][0], x);
                    }
                }
            }
            else if (x - king[0] == y - king[1]) {
                if (x > king[0]) {
                    // 右下
                    int tmp = 1 << 3;
                    if ((isVisited & tmp) == 0) {
                        // 还没有
                        visited[3][0] = x;
                        visited[3][1] = y;
                        isVisited += tmp;
                    } else {
                        visited[3][0] = Math.min(visited[3][0], x);
                        visited[3][1] = Math.min(visited[3][1], y);
                    }
                }
                if (x < king[0]) {
                    // 左上
                    int tmp = 1 << 7;
                    if ((isVisited & tmp) == 0) {
                        // 还没有
                        visited[7][0] = x;
                        visited[7][1] = y;
                        isVisited += tmp;
                    } else {
                        visited[7][0] = Math.max(visited[7][0], x);
                        visited[7][1] = Math.max(visited[7][1], y);
                    }
                }
            }
            else if (x + y == king[0] + king[1]){
                if (x > king[0]) {
                    // 左下
                    int tmp = 1 << 5;
                    if ((isVisited & tmp) == 0) {
                        // 还没有
                        visited[5][0] = x;
                        visited[5][1] = y;
                        isVisited += tmp;
                    } else {
                        visited[5][0] = Math.min(visited[5][0], x);
                        visited[5][1] = Math.max(visited[5][1], y);
                    }
                }
                if (x < king[0]) {
                    // 右上
                    int tmp = 1 << 1;
                    if ((isVisited & tmp) == 0) {
                        // 还没有
                        visited[1][0] = x;
                        visited[1][1] = y;
                        isVisited += tmp;
                    } else {
                        visited[1][0] = Math.max(visited[1][0], x);
                        visited[1][1] = Math.min(visited[1][1], y);
                    }
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            if ((isVisited & (1 << i)) != 0) {
                List<Integer> list = new ArrayList<>();
                list.add(visited[i][0]);
                list.add(visited[i][1]);
                res.add(list);
            }
        }
        return res;
    }

}
