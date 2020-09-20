package com.jack.algorithm.problem.pre;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jack
 */
public class Easy0874 {

    /**
     * 上、右、下、左
     **/
    private int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<Long> set = new HashSet<>();
        int obstacleMax = 30000;
        for (int[] obstacle : obstacles) {
            set.add((long) (obstacle[0] * obstacleMax + obstacle[1]));
        }
        int res = 0;
        // 记录当前的方向
        int curDir = 0;
        // 记录当前的位置
        int curX = 0, curY = 0;
        for (int command : commands) {
            if (command == -1) {
                // 右转
                curDir = (curDir + 1) % 4;
            } else if (command == -2) {
                // 左转
                curDir = (curDir + 3) % 4;
            } else {
                // 走
                for (int i = 0; i < command; i++) {
                    int x = curX + dirs[curDir][0];
                    int y = curY + dirs[curDir][1];
                    if (set.contains((long) (x * obstacleMax + y))) {
                        break;
                    }
                    curX = x;
                    curY = y;
                }
                res = Math.max(res, curX * curX + curY * curY);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Easy0874 main = new Easy0874();
        System.out.println(main.robotSim(
                new int[]{4, -1, 3}, new int[][]{}
        ));
        System.out.println(main.robotSim(
                new int[]{4, -1, 4, -2, 4}, new int[][]{{2, 4}}
        ));
    }
}