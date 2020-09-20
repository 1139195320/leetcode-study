package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0074 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) {
            return false;
        }
        int col = matrix[0].length;
        if (col == 0) {
            return false;
        }
        int targetRow = 0;
        if (target < matrix[0][0]
                || target > matrix[row - 1][col - 1]) {
            return false;
        }
        for (int i = 1; i < row; i++) {
            int preMax = matrix[i - 1][col - 1];
            int curMax = matrix[i][col - 1];
            if (target == preMax || target == curMax) {
                return true;
            }
            if (target > preMax && target < curMax) {
                targetRow = i;
                break;
            }
        }
        if (matrix[targetRow][0] == target) {
            return true;
        }
        if (matrix[targetRow][0] > target) {
            return false;
        }
        return find(matrix[targetRow], target, 0, col - 1);
    }
    private boolean find(int[] arr, int target, int l, int r) {
        if (r - l <= 1) {
            return arr[l] == target || arr[r] == target;
        }
        int m = (l + r) >> 1;
        int cur = arr[m];
        if (cur == target) {
            return true;
        }
        else if (cur < target) {
            return find(arr, target, m, r);
        }
        else {
            return find(arr, target, l, m);
        }
    }

    public static void main(String[] args) {
        LeetCode0074 main = new LeetCode0074();
        int[][] matrix = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        System.out.println(main.searchMatrix(matrix, 3));
        System.out.println(main.searchMatrix(matrix, 9));
        System.out.println(main.searchMatrix(matrix, 13));
    }
}