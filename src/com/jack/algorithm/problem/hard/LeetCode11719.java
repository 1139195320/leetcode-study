package com.jack.algorithm.problem.hard;

/**
 * @author jack
 */
public class LeetCode11719 {

    public int[] missingTwo(int[] nums) {
        int n = nums.length + 2;
        int[] tmp = new int[n];
        for (int num : nums) {
            tmp[num - 1] = 1;
        }
        int k = 0;
        int[] res = new int[2];
        for (int i = 0; i < n; i++) {
            if (tmp[i] == 0) {
                res[k ++] = i + 1;
                if (k == 2) {
                    break;
                }
            }
        }
        return res;
    }

    public int[] missingTwo2(int[] nums) {
        int res = 0;
        int n = nums.length;
        for (int i = 1; i <= n + 2; i++) {
            res ^= i;
        }
        for (int num : nums) {
            res ^= num;
        }
        int one = 0;
        int diff = res & -res;
        for (int i = 1; i <= n + 2; i++) {
            if ((diff & i) != 0) {
                one ^= i;
            }
        }
        for (int num : nums) {
            if ((diff & num) != 0) {
                one ^= num;
            }
        }
        return new int[] {one, one ^ res};
    }
}
