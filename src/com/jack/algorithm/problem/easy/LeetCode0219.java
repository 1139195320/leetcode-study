package com.jack.algorithm.problem.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jack
 */
public class LeetCode0219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < k && i < n; i++) {
            int cur = nums[i];
            if (set.contains(cur)) {
                return true;
            }
            set.add(cur);
        }
        int l = 0;
        for (int i = k; i < n; i++) {
            int cur = nums[i];
            if (set.contains(cur)) {
                return true;
            }
            set.add(cur);
            set.remove(nums[l ++]);
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode0219 main = new LeetCode0219();
        System.out.println(main.containsNearbyDuplicate(
                new int[]{1, 2, 3, 1}, 3
        ));
        System.out.println(main.containsNearbyDuplicate(
                new int[]{1, 2, 3, 1, 2, 3}, 2
        ));
    }
}