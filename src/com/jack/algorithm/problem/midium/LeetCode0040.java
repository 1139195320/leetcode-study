package com.jack.algorithm.problem.midium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jack
 */
public class LeetCode0040 {

    private List<List<Integer>> res;
    private void backtrace(int[] candidates, int target, int pre,
                           int start, List<Integer> curList) {
        if (pre == target) {
            res.add(new ArrayList<>(curList));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            int cur = candidates[i];
            if (i != start && candidates[i - 1] == cur) {
                continue;
            }
            if (pre + cur > target) {
                break;
            }
            curList.add(cur);
            backtrace(candidates, target, pre + cur, i + 1, curList);
            curList.remove(curList.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrace(candidates, target, 0, 0, new ArrayList<>());
        return res;
    }

    public static void main(String[] args) {
        LeetCode0040 main = new LeetCode0040();
        System.out.println(main.combinationSum2(
                new int[]{10, 1, 2, 7, 6, 1, 5}, 8
        ));
//        System.out.println(main.combinationSum2(
//                new int[]{2, 5, 2, 1, 2}, 5
//        ));
    }
}