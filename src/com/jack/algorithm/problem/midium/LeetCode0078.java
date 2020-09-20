package com.jack.algorithm.problem.midium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jack
 */
public class LeetCode0078 {

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        for (k = 0; k <= nums.length; k++) {
            doSubSets(nums, 0, new ArrayList<>());
        }
        return res;
    }

    /**
     * 子集的长度
     */
    private int k;
    private List<List<Integer>> res = new ArrayList<>();
    private void doSubSets(int[] nums, int start, List<Integer> list) {
        if (list.size() == k) {
            res.add(new ArrayList<>(list));
        }
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            doSubSets(nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        LeetCode0078 main = new LeetCode0078();
        System.out.println(
                main.subsets(
                        new int[] {1, 2, 3}
                )
        );
    }
}