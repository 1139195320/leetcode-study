package com.jack.algorithm.problem.pre;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jack
 */
public class Medium10804 {

    private List<List<Integer>> res;
    private int k;
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        res = new ArrayList<>();
        for (k = 0; k <= nums.length; k++) {
            dfs(nums, 0, new ArrayList<>());
        }
        return res;
    }
    private void dfs(int[] nums, int start, List<Integer> curList) {
        if (curList.size() == k) {
            res.add(new ArrayList<>(curList));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            curList.add(nums[i]);
            dfs(nums, i + 1, curList);
            curList.remove(curList.size() - 1);
        }
    }

    public static void main(String[] args) {
        Medium10804 main = new Medium10804();
        System.out.println(main.subsets(
                new int[]{1, 2, 3}
        ));
    }
}