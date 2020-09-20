package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Medium11009 {

    private int row = 0, col = 0;
    private boolean isValid(int x, int y) { return x < row && y < col; }
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        this.row = matrix.length;
        this.col = matrix[0].length;
        return searchMatrix(matrix, target, 0, 0);
    }
    public boolean searchMatrix(int[][] matrix, int target, int x, int y) {
        if (!isValid(x, y)) {
            return false;
        }
        if (matrix[x][y] > target) {
            return false;
        }
        return matrix[x][y] == target
                || searchMatrix(matrix, target, x + 1, y)
                || searchMatrix(matrix, target, x, y + 1);
    }

    public static void main(String[] args) {
        Medium11009 main = new Medium11009();
        int [][] matrix = new int[][] {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(main.searchMatrix(matrix, 5));
        System.out.println(main.searchMatrix(matrix, 20));
    }
}