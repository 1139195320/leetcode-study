package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Medium0376 {

    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int up = 1;
        int down = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }

    public static void main(String[] args) {
        Medium0376 main = new Medium0376();
        System.out.println(main.wiggleMaxLength(
                new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}
        ));
        System.out.println(main.wiggleMaxLength(
                new int[]{1, 2, 3, 4, 5}
        ));
    }
}