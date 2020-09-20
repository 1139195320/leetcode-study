package com.jack.algorithm.problem.midium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jack
 */
public class LeetCode0039 {

    private List<List<Integer>> res;
    private void backtrace(int[] candidates, int target, int pre,
                           int start, List<Integer> curList) {
        if (pre == target) {
            res.add(new ArrayList<>(curList));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            int cur = candidates[i];
            if (pre + cur > target) {
                break;
            }
            curList.add(cur);
            backtrace(candidates, target, pre + cur, i, curList);
            curList.remove(curList.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrace(candidates, target, 0, 0, new ArrayList<>());
        return res;
    }

    public static void main(String[] args) {
        LeetCode0039 main = new LeetCode0039();
        System.out.println(main.combinationSum(
                new int[] {2, 3, 6, 7}, 7
        ));
    }
}
