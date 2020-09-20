package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0152 {

    public int maxProduct(int[] nums) {
        int maxProduct = -Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int curProduct = 1;
            int curMaxProduct = -Integer.MAX_VALUE;
            for (int j = i; j < nums.length; j++) {
                curProduct *= nums[j];
                curMaxProduct = Math.max(curMaxProduct, curProduct);
            }
            maxProduct = Math.max(maxProduct, curMaxProduct);
        }
        return maxProduct;
    }

    public int maxProduct2(int[] nums) {
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int preMaxProduct = maxProduct;
            int preMinProduct = minProduct;
            maxProduct = Math.max(preMaxProduct * nums[i],
                    Math.max(nums[i], preMinProduct * nums[i]));
            minProduct = Math.min(preMinProduct * nums[i],
                    Math.min(nums[i], preMaxProduct * nums[i]));
            res = Math.max(res, maxProduct);
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0152 main = new LeetCode0152();
        System.out.println(main.maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(main.maxProduct(new int[]{-2, 0, -1}));
        System.out.println(main.maxProduct2(new int[]{2, 3, -2, 4}));
        System.out.println(main.maxProduct2(new int[]{-2, 0, -1}));
    }
}
