package com.jack.algorithm.problem.pre;

import java.util.*;

/**
 * @author jack
 */
public class Medium11622 {

    public List<String> printKMoves(int K) {
        List<String> res = new ArrayList<>();
        Set<Position> blackSet = new HashSet<>();
        char[] direction = {'R', 'D', 'L', 'U'};
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        // 初始的时候，面向右侧
        // 右转走一步，即往下走一步
        int cur = 0;
        Position antPos = new Position(0, 0);
        while (K > 0) {
            Position curPos = new Position(antPos.x, antPos.y);
            if (blackSet.add(curPos)) {
                // 此坐标为白色，现在置为黑
                cur = (cur + 1) % 4;
            } else {
                // 此坐标为黑色
                blackSet.remove(curPos);
                cur = (cur + 3) % 4;
            }
            int[] dir = dirs[cur];
            antPos.x += dir[0];
            antPos.y += dir[1];
            K --;
        }
        int left = antPos.x;
        int right = antPos.x;
        int top = antPos.y;
        int bottom = antPos.y;
        for (Position blackPos : blackSet) {
            left = Math.min(left, blackPos.x);
            right = Math.max(right, blackPos.x);
            top = Math.min(top, blackPos.y);
            bottom = Math.max(bottom, blackPos.y);
        }
        int row = bottom - top + 1;
        int col = right - left + 1;
        char[][] grid = new char[row][col];
        // 填充白点
        for (int i = 0; i < row; i++) {
            Arrays.fill(grid[i], '_');
        }
        // 填充黑点
        for (Position blackPos : blackSet) {
            grid[blackPos.y - top][blackPos.x - left] = 'X';
        }
        // 填充蚂蚁所在点
        grid[antPos.y - top][antPos.x - left] = direction[cur];
        for (char[] curRow : grid) {
            res.add(String.valueOf(curRow));
        }
        return res;
    }
    private static class Position {
        int x;
        int y;
        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            if (obj instanceof Position) {
                Position other = (Position) obj;
                return x == other.x && y == other.y;
            }
            return false;
        }
        @Override
        public int hashCode() {
            return x * 31 + y;
        }
    }

    public static void main(String[] args) {
        Medium11622 main = new Medium11622();
        System.out.println(main.printKMoves(0));
        System.out.println(main.printKMoves(2));
        System.out.println(main.printKMoves(5));
    }
}