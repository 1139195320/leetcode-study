package com.jack.algorithm.problem.midium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jack
 */
public class LeetCode0491 {

    public List<List<Integer>> findSubsequences(int[] nums) {
        resSet = new HashSet<>();
        backtrace(nums, 0, -101, new ArrayList<>());
        return new ArrayList<>(resSet);
    }
    private Set<List<Integer>> resSet;
    private void backtrace(int[] nums, int start, int pre, List<Integer> curList) {
        if (curList.size() > 1) {
            resSet.add(new ArrayList<>(curList));
        }
        for (int i = start; i < nums.length; i++) {
            int cur = nums[i];
            if (cur >= pre) {
                curList.add(cur);
                backtrace(nums, i + 1, cur, curList);
                curList.remove(curList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        LeetCode0491 main = new LeetCode0491();
        System.out.println(main.findSubsequences(
                new int[]{4, 6, 7, 7}
        ));
    }
}