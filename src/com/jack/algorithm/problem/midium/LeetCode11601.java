package com.jack.algorithm.problem.midium;

import java.util.Arrays;

/**
 * @author jack
 */
public class LeetCode11601 {

    public int[] swapNumbers(int[] numbers) {
        numbers[0] += numbers[1];
        numbers[1] = numbers[0] - numbers[1];
        numbers[0] -= numbers[1];
        return numbers;
    }

    public int[] swapNumbers2(int[] numbers) {
        numbers[0] ^= numbers[1];
        numbers[1] ^= numbers[0];
        numbers[0] ^= numbers[1];
        return numbers;
    }

    public static void main(String[] args) {
        LeetCode11601 main = new LeetCode11601();
        System.out.println(Arrays.toString(main.swapNumbers(new int[]{1, 2})));
        System.out.println(Arrays.toString(main.swapNumbers2(new int[]{1, 2})));
    }
}
