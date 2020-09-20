package com.jack.algorithm.problem.midium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jack
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），
 * 可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 */
public class LeetCode0287 {

    public int findDuplicate(int[] nums) {
        int[] arr = new int[nums.length];
        for (int num : nums) {
            if (arr[num] == 1) {
                return num;
            }
            arr[num] = 1;
        }
        return -1;
    }

    public int findDuplicate2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length - 1);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    /**
     * 快慢指针走圈法
     */
    public int findDuplicate3(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    /**
     * 二进制法
     */
    public int findDuplicate4(int[] nums) {
        int n = nums.length, res = 0;
        int bit_max = 31;
        while (((n - 1) >> bit_max) == 0) {
            bit_max -= 1;
        }
        for (int bit = 0; bit <= bit_max; ++bit) {
            int x = 0, y = 0;
            for (int i = 0; i < n; ++i) {
                if ((nums[i] & (1 << bit)) != 0) {
                    x += 1;
                }
                if (i >= 1 && ((i & (1 << bit)) != 0)) {
                    y += 1;
                }
            }
            if (x > y) {
                res |= 1 << bit;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0287 main = new LeetCode0287();
        System.out.println(main.findDuplicate(new int[]{1, 3, 3, 2}));
        System.out.println(main.findDuplicate2(new int[]{1, 3, 3, 2}));
        System.out.println(main.findDuplicate3(new int[]{1, 3, 3, 2}));
        System.out.println(main.findDuplicate(new int[]{1, 3, 3, 4, 3, 2}));
        System.out.println(main.findDuplicate2(new int[]{1, 3, 3, 4, 3, 2}));
        System.out.println(main.findDuplicate3(new int[]{1, 3, 3, 4, 3, 2}));
    }
}