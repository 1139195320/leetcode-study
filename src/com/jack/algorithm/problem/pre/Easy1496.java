package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Easy1496 {

    public boolean isPathCrossing(String path) {
        int n = 10000;
        boolean[][] visited = new boolean[n << 1][n << 1];
        int x = 0;
        int y = 0;
        visited[x][y] = true;
        for (char c : path.toCharArray()) {
            if (c == 'N') {
                y += 1;
            } else if (c == 'S') {
                y -= 1;
            } else if (c == 'E') {
                x += 1;
            } else if (c == 'W') {
                x -= 1;
            }
            if (visited[x][y]) {
                return true;
            }
            visited[x][y] = true;
        }
        return false;
    }

    public static void main(String[] args) {
        Easy1496 main = new Easy1496();
        System.out.println(main.isPathCrossing("NES"));
        System.out.println(main.isPathCrossing("NESWW"));
    }
}