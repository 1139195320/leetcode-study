package com.jack.algorithm.problem.midium;

import java.util.Arrays;

/**
 * @author jack
 */
public class LeetCode1300 {

    public int findBestValue(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        Arrays.sort(arr);
        int preSum = 0;
        int minVal = arr[arr.length - 1];
        // 剩余元素数量
        int surplusSize = arr.length;
        for (int i = 0; i < arr.length; i++, surplusSize --) {
            int val = (target - preSum) / surplusSize;
            int cur = arr[i];
            if (val <= cur) {
                int disparity1 = target
                        - (surplusSize * val + preSum);
                int disparity2 = surplusSize * (val + 1) + preSum
                        - target;
                if (disparity1 == 0) {
                    minVal = val;
                }
                else if (disparity2 == 0) {
                    minVal = val + 1;
                }
                else if (disparity1 <= disparity2) {
                    minVal = val;
                }
                else {
                    minVal = val + 1;
                }
                break;
            }
            preSum += cur;
        }
        return minVal;
    }

    public static void main(String[] args) {
        LeetCode1300 main = new LeetCode1300();
        System.out.println(main.findBestValue(
                new int[] {4, 9, 3},
                100
        ));
        System.out.println(main.findBestValue(
                new int[] {4, 9, 3},
                10
        ));
        System.out.println(main.findBestValue(
                new int[] {2, 3, 5},
                10
        ));
        System.out.println(main.findBestValue(
                new int[]{60864, 25176, 27249, 21296, 20204},
                56803
        ));
    }
}
