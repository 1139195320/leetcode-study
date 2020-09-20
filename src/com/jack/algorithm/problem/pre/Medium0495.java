package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Medium0495 {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int res = 0;
        int curEnd = 0;
        for (int timeSery : timeSeries) {
            if (timeSery > curEnd) {
                curEnd = timeSery + duration - 1;
                res += duration;
            } else {
                int adder = duration - (curEnd - timeSery + 1);
                curEnd += adder;
                res += adder;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Medium0495 main = new Medium0495();
        System.out.println(main.findPoisonedDuration(
                new int[]{1, 4}, 2
        ));
        System.out.println(main.findPoisonedDuration(
                new int[]{1, 2}, 2
        ));
    }
}