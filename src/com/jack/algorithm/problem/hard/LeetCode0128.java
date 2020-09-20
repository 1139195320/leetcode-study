package com.jack.algorithm.problem.hard;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jack
 */
public class LeetCode0128 {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int curRes = 1;
                int nextNum = num + 1;
                while (set.contains(nextNum)) {
                    curRes ++;
                    nextNum ++;
                }
                res = Math.max(res, curRes);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0128 main = new LeetCode0128();
        System.out.println(main.longestConsecutive(new int[] {
                100, 4, 200, 1, 3, 2
        }));
    }
}