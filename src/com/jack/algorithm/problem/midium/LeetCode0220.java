package com.jack.algorithm.problem.midium;

import java.util.TreeSet;

/**
 * @author jack
 */
public class LeetCode0220 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) {
            return false;
        }
        // nums [i] 和 nums [j] 的差的绝对值小于等于 t
        // 且满足 i 和 j 的差的绝对值也小于等于 ķ
        TreeSet<Integer> set = new TreeSet<>();
        int n = nums.length;
        for (int i = 0; i < Math.min(k + 1, n); i++) {
            int cur = nums[i];
            if (set.contains(cur)) {
                return true;
            }
            Integer lMax = set.floor(cur);
            if (lMax != null) {
                int diff = cur - lMax;
                if (diff > 0 && diff <= t) {
                    return true;
                }
            }
            Integer rMin = set.ceiling(cur);
            if (rMin != null) {
                int diff = rMin - cur;
                if (diff > 0 && diff <= t) {
                    return true;
                }
            }
            set.add(cur);
        }
        int l = 0;
        int r = k + 1;
        for (; r < n; r++, l++) {
            set.remove(nums[l]);
            int cur = nums[r];
            if (set.contains(cur)) {
                return true;
            }
            Integer lMax = set.floor(cur);
            if (lMax != null) {
                int diff = cur - lMax;
                if (diff > 0 && diff <= t) {
                    return true;
                }
            }
            Integer rMin = set.ceiling(cur);
            if (rMin != null) {
                int diff = rMin - cur;
                if (diff > 0 && diff <= t) {
                    return true;
                }
            }
            set.add(cur);
        }
        return false;
    }

    public static void main(String[] args) {
        LeetCode0220 main = new LeetCode0220();
        System.out.println(main.containsNearbyAlmostDuplicate(
                new int[]{2, 1}, 1, 1
        ));
        System.out.println(main.containsNearbyAlmostDuplicate(
                new int[]{1, 2, 3, 1}, 3, 0
        ));
        System.out.println(main.containsNearbyAlmostDuplicate(
                new int[]{1, 0, 1, 1}, 1, 2
        ));
        System.out.println(main.containsNearbyAlmostDuplicate(
                new int[]{1, 5, 9, 1, 5, 9}, 2, 3
        ));
    }
}