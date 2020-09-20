package com.jack.algorithm.problem.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jack
 */
public class LeetCode0980 {

    /**
     * 路径数量
     **/
    private int res;
    private int row;
    private int col;
    private int n;
    private int count;
    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private boolean[][] visited;
    private int[][] grid;
    private int startX, startY;
    private int endX, endY;
    private boolean isValid(int x, int y) {
        return x >= 0 && x < row
                && y >= 0 && y < col
                && !visited[x][y]
                && grid[x][y] == 0;
    }
    public int uniquePathsIII(int[][] grid) {
        this.grid = grid;
        this.row = grid.length;
        this.col = grid[0].length;
        this.visited = new boolean[row][col];
        n = 0;
        count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) {
                    // 无障碍空方格
                    n ++;
                }
                else if (grid[i][j] == 1) {
                    // 起始点
                    startX = i;
                    startY = j;
                }
                else if (grid[i][j] == 2) {
                    // 结束点
                    endX = i;
                    endY = j;
                }
            }
        }
        this.res = 0;
        dfs(startX, startY, true);
        return res;
    }
    private void dfs(int curX, int curY, boolean begin) {
        if (curX == endX && curY == endY) {
            if (count == n + 1) {
                res ++;
            }
            return;
        }
        boolean isFirst = curX == startX && curY == startY && begin;
        if (!isValid(curX, curY) && !isFirst) {
            return;
        }
        for (int[] dir : dirs) {
            int x = curX + dir[0];
            int y = curY + dir[1];
            visited[curX][curY] = true;
            count ++;
            dfs(x, y, false);
            count --;
            visited[curX][curY] = false;
        }
    }




    /**
     * 路径
     **/
    private List<List<List<Integer>>> pathList;
    public List<List<List<Integer>>> uniquePathsIII2(int[][] grid) {
        this.grid = grid;
        this.row = grid.length;
        this.col = grid[0].length;
        this.pathList = new ArrayList<>();
        this.visited = new boolean[row][col];
        n = 0;
        count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) {
                    // 无障碍空方格
                    n ++;
                }
                else if (grid[i][j] == 1) {
                    // 起始点
                    startX = i;
                    startY = j;
                }
                else if (grid[i][j] == 2) {
                    // 结束点
                    endX = i;
                    endY = j;
                }
            }
        }
        dfs2(startX, startY, true, new ArrayList<>());
        return pathList;
    }
    private void dfs2(int curX, int curY, boolean begin,
                      List<List<Integer>> curLists) {
        List<Integer> list = new ArrayList<>();
        list.add(curX);
        list.add(curY);
        if (curX == endX && curY == endY) {
            if (count == n + 1) {
                List<List<Integer>> lists = new ArrayList<>(curLists);
                lists.add(list);
                pathList.add(lists);
            }
            return;
        }
        boolean isFirst = curX == startX && curY == startY && begin;
        if (!isValid(curX, curY) && !isFirst) {
            return;
        }
        for (int[] dir : dirs) {
            int x = curX + dir[0];
            int y = curY + dir[1];
            visited[curX][curY] = true;
            count ++;
            curLists.add(list);
            dfs2(x, y, false, curLists);
            curLists.remove(curLists.size() - 1);
            count --;
            visited[curX][curY] = false;
        }
    }

    public static void main(String[] args) {
        LeetCode0980 main = new LeetCode0980();
        System.out.println(main.uniquePathsIII(
                new int[][]{
                        {1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}
                }
        ));
        System.out.println(main.uniquePathsIII(
                new int[][]{
                        {1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 2}
                }
        ));
        System.out.println(main.uniquePathsIII(
                new int[][] {
                        {0, 1},{2, 0}
                }
        ));
//        List<List<List<Integer>>> lists = main.uniquePathsIII2(
//                new int[][]{
//                        {1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}
//                }
//        );
//        for (List<List<Integer>> list : lists) {
//            System.out.println(list);
//        }
    }
}