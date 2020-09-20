package com.jack.algorithm.problem.midium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jack
 */
public class LeetCode0794 {

    public boolean validTicTacToe(String[] board) {
        char[][] arr = new char[3][3];
        int sizeA = 0;
        int sizeB = 0;
        List<String> list = new ArrayList<>();
        StringBuilder sbLeft = new StringBuilder();
        StringBuilder sbRight = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            String str = board[i];
            list.add(str);
            sbLeft.append(str.charAt(i));
            sbRight.append(str.charAt(board.length - i - 1));
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (c == 'X') {
                    sizeA ++;
                }
                if (c == 'O') {
                    sizeB ++;
                }
                arr[j][i] = c;
            }
        }
        if (sizeA < sizeB || sizeA - sizeB > 1) {
            return false;
        }
        list.add(sbLeft.toString());
        list.add(sbRight.toString());
        for (char[] chars : arr) {
            list.add(new String(chars));
        }
        if (list.contains("XXX")
                && (sizeA <= sizeB || list.contains("OOO"))) {
            return false;
        }
        if (list.contains("OOO") && sizeA != sizeB) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        LeetCode0794 main = new LeetCode0794();
        System.out.println(main.validTicTacToe(
                new String[] {"O  ", "   ", "   "}
        ));
        System.out.println(main.validTicTacToe(
                new String[] {"XOX", " X ", "   "}
        ));
        System.out.println(main.validTicTacToe(
                new String[] {"XXX", "   ", "OOO"}
        ));
        System.out.println(main.validTicTacToe(
                new String[] {"XOX", "O O", "XOX"}
        ));
        System.out.println(main.validTicTacToe(
                new String[]{"OXX", "XOX", "OXO"}
        ));
    }
}