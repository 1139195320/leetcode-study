package com.jack.algorithm.problem.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jack
 */
public class LeetCode0268 {

    public int missingNumber(int[] nums) {
        // 求和
        int n = nums.length;
        int expectSum = (n + 1) * n / 2;
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        return expectSum - actualSum;
    }

    public int missingNumber2(int[] nums) {
        // 借助 set
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 0; i < (nums.length + 1); i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    public int missingNumber3(int[] nums) {
        // 位运算
        int xor = 0;
        for (int i = 0; i < (nums.length + 1); i++) {
            xor ^= i;
        }
        for (int num : nums) {
            xor ^= num;
        }
        return xor;
    }
}
