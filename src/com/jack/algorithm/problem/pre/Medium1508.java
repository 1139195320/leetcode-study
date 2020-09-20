package com.jack.algorithm.problem.pre;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author jack
 */
public class Medium1508 {

    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            dfs(nums, list, i + 1, nums[i]);
        }
        Collections.sort(list);
        int res = 0;
        int MOD = 1_000_000_007;
        for (int i = left - 1; i < right; i++) {
            res += list.get(i);
            res %= MOD;
        }
        return res;
    }
    private void dfs(int[] nums, List<Integer> list, int start, int preSum) {
        list.add(preSum);
        if (start == nums.length) {
            return;
        }
        dfs(nums, list, start + 1, preSum + nums[start]);
    }

    public static void main(String[] args) {
        Medium1508 main = new Medium1508();
        // 1, 2, 3, 3, 4, 5, 6, 7, 9, 10
        System.out.println(main.rangeSum(
                new int[] {1, 2, 3, 4}, 4, 1, 5
        ));
        System.out.println(main.rangeSum(
                new int[] {1, 2, 3, 4}, 4, 3, 4
        ));
        System.out.println(main.rangeSum(
                new int[] {1, 2, 3, 4}, 4, 1, 10
        ));
    }
}