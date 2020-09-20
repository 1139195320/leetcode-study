package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode10011 {

    public int minArray(int[] numbers) {
        int n = numbers.length;
        if (n == 1) {
            return numbers[0];
        }
        if (numbers[0] < numbers[n - 1]) {
            return numbers[0];
        }
        int res = numbers[0];
        for (int number : numbers) {
            if (number < res) {
                res = number;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode10011 main = new LeetCode10011();
    }
}