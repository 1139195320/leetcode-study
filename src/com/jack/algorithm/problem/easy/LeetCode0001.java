package com.jack.algorithm.problem.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jack
 */
public class LeetCode0001 {

    boolean[]visited;
    public int[] twoSum(int[] nums, int target) {
        visited = new boolean[nums.length];
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            visited[i] = true;
            for (int j = 0; j < nums.length; j++) {
                if (visited[j]) {
                    continue;
                }
                if (target - nums[j] == num) {
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }
    public int[] twoSum2(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])
                    && map.get(target - nums[i]) != i) {
                // found
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
