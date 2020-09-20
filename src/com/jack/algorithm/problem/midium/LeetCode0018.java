package com.jack.algorithm.problem.midium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jack
 */
public class LeetCode0018 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return res;
        }
        int len = nums.length;
        Arrays.sort(nums);
        if (nums[0] + nums[1] + nums[2] + nums[3] > target) {
            return res;
        }
        if (nums[len - 1] + nums[len - 2] + nums[len - 3] + nums[len - 4] < target) {
            return res;
        }
        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                // 去重不能漏
                continue;
            }
            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    // 去重不能漏
                    continue;
                }
                int need = target - nums[i] - nums[j];
                int l = j + 1;
                int r = len - 1;
                while (l < r) {
                    if (nums[l] + nums[r] == need) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        res.add(list);
                        l ++;
                        while (l < r && nums[l] == nums[l - 1]) {
                            // 去重不能漏
                            l++;
                        }
                        r --;
                        while (l < r && nums[l] == nums[l - 1]) {
                            // 去重不能漏
                            r--;
                        }
                    }
                    else if (nums[l] + nums[r] > need) {
                        r --;
                    }
                    else {
                        l ++;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0018 main = new LeetCode0018();
        System.out.println(main.fourSum(
                new int[]{1, 0, -1, 0, -2, 2}, 0
        ));
        System.out.println(main.fourSum(
                new int[]{-3, -2, -1, 0, 0, 1, 2, 3}, 0
        ));
        System.out.println(main.fourSum(
                new int[]{0, 0, 0, 0}, 0
        ));
        System.out.println(main.fourSum(
                new int[]{-1, -5, -5, -3, 2, 5, 0, 4}, -7
        ));
        System.out.println(main.fourSum(
                new int[]{-1, 0, -5, -2, -2, -4, 0, 1, -2}, -9
        ));
    }
}