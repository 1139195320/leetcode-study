package com.jack.algorithm.problem.pre;

import java.util.Arrays;

/**
 * @author jack
 */
public class Medium11011 {

    public void wiggleSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if ((i & 1) == 0 && nums[i] < nums[i + 1]
                    || (i & 1) != 0 && nums[i] > nums[i + 1]) {
                int tmp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        Medium11011 main = new Medium11011();
        int[] arr = new int[]{5, 3, 1, 2, 3};
        main.wiggleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}