package com.jack.algorithm.problem.pre;

import java.util.Arrays;

/**
 * @author jack
 */
public class Medium1498 {

    public int numSubseq(int[] nums, int target) {
        int n = nums.length;
        int[] tmp = new int[n];
        Arrays.sort(nums);
        if (n == 0 || nums[0] > target) {
            return 0;
        }
        int MOD = 1_000_000_007;
        // 下标从 0 ~ i-1 的排列组合
        // 即取当前的数，前面的数取与不取的组合数
        tmp[0] = 1;
        for (int i = 1; i < n; i++) {
            tmp[i] = tmp[i - 1] << 1;
            tmp[i] %= MOD;
        }
        int l = 0, r = n - 1;
        int res = 0;
        while (l <= r) {
            if (nums[l] + nums[r] > target) {
                r --;
            } else {
                // 直接取 l ~ r 间的组合数
                res += tmp[r - l];
                l ++;
                res %= MOD;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Medium1498 main = new Medium1498();
        System.out.println(main.numSubseq(
                new int[]{3, 5, 6, 7}, 9
        ));
    }
}