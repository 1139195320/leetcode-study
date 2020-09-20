package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0657 {

    public boolean judgeCircle(String moves) {
        // L R U D
        int[] steps = new int[4];
        for (char c : moves.toCharArray()) {
            if (c == 'L') {
                steps[0] ++;
            }
            else if (c == 'R') {
                steps[1] ++;
            }
            else if (c == 'U') {
                steps[2] ++;
            }
            else {
                steps[3] ++;
            }
        }
        return steps[0] == steps[1]
                && steps[2] == steps[3];
    }

    public boolean judgeCircle2(String moves) {
        int x = 0, y = 0;
        for (char c : moves.toCharArray()) {
            if (c == 'L') {
                x --;
            } else if (c == 'R') {
                x ++;
            } else if (c == 'U') {
                y --;
            } else {
                y ++;
            }
        }
        return x == 0 && y == 0;
    }

    public static void main(String[] args) {
        LeetCode0657 main = new LeetCode0657();
        System.out.println(main.judgeCircle("LR"));
        System.out.println(main.judgeCircle("UD"));
        System.out.println(main.judgeCircle("LL"));
    }

}