package com.jack.algorithm.problem.pre;

import java.util.*;

/**
 * @author jack
 */
public class Medium11624 {

    public List<List<Integer>> pairSums(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            int other = target - num;
            int count1 = countMap.getOrDefault(num, 0);
            int count2 = countMap.getOrDefault(other, 0);
            if (count1 > 0 && count2 > 0) {
                res.add(Arrays.asList(num, other));
                countMap.put(num, count1 - 1);
                countMap.put(other, count2 - 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Medium11624 main = new Medium11624();
        System.out.println(main.pairSums(
                new int[]{5, 6, 5}, 11
        ));
        System.out.println(main.pairSums(
                new int[]{5, 6, 5, 6}, 11
        ));
    }
}