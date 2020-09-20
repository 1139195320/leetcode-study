package com.jack.algorithm.problem.midium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fy
 */
public class LeetCode1248 {

    public int numberOfSubarrays(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        // 当前位置奇数左边的偶数个数
        int curSize = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                // 当前位置是偶数
                curSize++;
            } else {
                // 当前位置是奇数
                list.add(curSize);
                curSize = 0;
            }
        }
        // 最右边的偶数个数
        list.add(curSize);
        // 实际的奇数个数
        int size = list.size() - 1;
        if (size < k) {
            return 0;
        }
        int sum = 0;
        // 奇数个数计数
        int i = 0;
        int startIndex = 0;
        for (int j = 0; j < size; j++) {
            if (i != k ) {
                i ++;
            }
            if (i == k) {
                sum += (list.get(startIndex) + 1)
                        * (list.get(j + 1) + 1);
                startIndex ++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        LeetCode1248 main = new LeetCode1248();
        // 2 = 1 * 1 + 1 * 1
        System.out.println(main.numberOfSubarrays(
                new int[]{1, 1, 2, 1, 1}, 3));
        // 0 = 0
        System.out.println(main.numberOfSubarrays(
                new int[]{2, 4, 6}, 1));
        // 16 = (3 + 1) * (3 + 1)
        System.out.println(main.numberOfSubarrays(
                new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2}, 2));
        // 14 = (1 + 1) * (2 + 1) + (1 + 1) * (3 + 1)
        System.out.println(main.numberOfSubarrays(
                new int[]{2, 1, 2, 1, 2, 2, 1, 2, 2, 2}, 2));
    }
}
