package com.jack.algorithm.problem.hard;

/**
 * @author jack
 */
public class LeetCode101721 {

    public int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }
        int maxHeight = height[0];
        int maxIndex = 0;
        for (int i = 1; i < height.length; i++) {
            if (height[i] > maxHeight) {
                maxHeight = height[i];
                maxIndex = i;
            }
        }
        int res = 0;
        int curMaxHeight = height[0];
        for (int i = 0; i < maxIndex; i++) {
            int curHeight = height[i];
            if (curMaxHeight > curHeight) {
                res += (curMaxHeight - curHeight);
            } else {
                curMaxHeight = curHeight;
            }
        }
        curMaxHeight = height[height.length - 1];
        for (int i = height.length - 1; i > maxIndex; i--) {
            int curHeight = height[i];
            if (curMaxHeight > curHeight) {
                res += (curMaxHeight - curHeight);
            } else {
                curMaxHeight = curHeight;
            }
        }
        return res;
    }

    public int trap2(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }
        int res = 0;
        int i = 0;
        int j = height.length - 1;
        int preMaxHeightI = 0;
        int preMaxHeightJ = 0;
        while (i != j) {
            if (height[i] <= height[j]) {
                if (height[i] > preMaxHeightI) {
                    preMaxHeightI = height[i];
                } else {
                    res += preMaxHeightI - height[i];
                }
                i ++;
            } else {
                if (height[j] > preMaxHeightJ) {
                    preMaxHeightJ = height[j];
                } else {
                    res += preMaxHeightJ - height[j];
                }
                j --;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode101721 main = new LeetCode101721();
        // 6
        System.out.println(main.trap(
                new int[]{
                        0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1
                }
        ));
        System.out.println(main.trap2(
                new int[]{
                        0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1
                }
        ));
        System.out.println(main.trap(
                new int[]{
                        3
                }
        ));
    }
}