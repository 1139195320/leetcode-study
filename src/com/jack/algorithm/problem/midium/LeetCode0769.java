package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0769 {

    public int maxChunksToSorted(int[] arr) {
        int res = 0;
        int curMax = 0;
        for (int i = 0; i < arr.length; i++) {
            curMax = Math.max(curMax, arr[i]);
            if (curMax == i) {
                res ++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0769 main = new LeetCode0769();
        System.out.println(main.maxChunksToSorted(
                new int[] {4, 3, 2, 1, 0}
        ));
        System.out.println(main.maxChunksToSorted(
                new int[]{1, 0, 2, 3, 4}
        ));
    }
}