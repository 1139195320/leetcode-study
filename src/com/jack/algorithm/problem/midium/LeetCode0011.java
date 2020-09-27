package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0011 {

    /**
     * 暴力法，遍历所有的可能
     */
    public int maxArea(int[] height) {
        int res = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i; j < height.length; j++) {
                res = Math.max(res, (j - i) * Math.min(height[i], height[j]));
            }
        }
        return res;
    }

    /**
     * 长短指针，不断移动短指针，以求最大
     */
    public int maxArea2(int[] height) {
        int res = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            res = Math.max(res, (j - i) * Math.min(height[i], height[j]));
            if (height[i] <= height[j]) {
                i ++;
            } else {
                j --;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0011 main = new LeetCode0011();
        System.out.println(main.maxArea2(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
