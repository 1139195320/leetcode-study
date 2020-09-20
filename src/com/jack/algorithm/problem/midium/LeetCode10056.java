package com.jack.algorithm.problem.midium;

/**
 * @author fy
 */
public class LeetCode10056 {

    public int[] singleNumbers(int[] nums) {
        if (nums == null) {
            return null;
        }
        if (nums.length == 1) {
            return nums;
        }
        int a = 0;
        int b = 0;
        int x = 0;
        for (int num : nums) {
            x ^= num;
        }
        int xi = 1;
        while ((x & xi) == 0) {
            xi <<= 1;
        }
        for (int num : nums) {
            if ((num & xi) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }
        return new int[]{a, b};
    }

    public static void main(String[] args) {
        LeetCode10056 main = new LeetCode10056();
        int[] nums = main.singleNumbers(new int[]{4, 1, 4, 6});
        if (nums != null) {
            for (int num : nums) {
                System.out.println(num);
            }
        }
    }

}
