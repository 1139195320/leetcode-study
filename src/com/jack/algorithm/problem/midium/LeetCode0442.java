package com.jack.algorithm.problem.midium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jack
 */
public class LeetCode0442 {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                res.add(entry.getKey());
            }
        }
        return res;
    }

    public List<Integer> findDuplicates2(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int tmp = Math.abs(nums[i]) - 1;
            if (nums[tmp] < 0) {
                res.add(tmp + 1);
            }
            if (nums[tmp] > 0) {
                nums[tmp] *= -1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0442 main = new LeetCode0442();
        System.out.println(main.findDuplicates(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        System.out.println(main.findDuplicates2(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }
}
