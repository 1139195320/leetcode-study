package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0036 {

    private int[] visitedRow;
    private int[] visitedCol;
    private int[][] visitedBoard;
    /**
     * 可以选的数字
     */
    private int[] dataArr;
    private char[][] board;
    public boolean isValidSudoku(char[][] board) {
        dataArr = new int[9];
        this.board = board;
        for (int i = 0; i < dataArr.length; i++) {
            dataArr[i] = i + 1;
        }
        int row = board.length;
        int col = board[0].length;
        visitedRow = new int[row];
        visitedCol = new int[col];
        visitedBoard = new int[row / 3][col / 3];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int tmp = 1 << (c - '0');
                    if ((visitedRow[i] & tmp) != 0
                            || (visitedCol[j] & tmp) != 0
                            || (visitedBoard[i / 3][j / 3] & tmp) != 0) {
                        // 行有这个数
                        // 列有这个数
                        // 当前 3 * 3 方块儿有这个数
                        return false;
                    }
                    visitedRow[i] += tmp;
                    visitedCol[j] += tmp;
                    visitedBoard[i / 3][j / 3] += tmp;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode0036 main = new LeetCode0036();
        char[][] board = new char[][] {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'},
        };
        System.out.println(main.isValidSudoku(board));
    }
}
