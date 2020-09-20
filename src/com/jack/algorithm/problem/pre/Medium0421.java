package com.jack.algorithm.problem.pre;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jack
 */
public class Medium0421 {

    public int findMaximumXOR(int[] nums) {
        int maxNum = nums[0];
        for(int num : nums) {
            maxNum = Math.max(maxNum, num);
        }
        int len = (Integer.toBinaryString(maxNum)).length();

        int maxXor = 0, curXor;
        Set<Integer> prefixes = new HashSet<>();
        for(int i = len - 1; i > -1; --i) {
            maxXor <<= 1;
            curXor = maxXor | 1;
            prefixes.clear();
            for(int num: nums) {
                prefixes.add(num >> i);
            }
            for(int p: prefixes) {
                if (prefixes.contains(curXor ^ p)) {
                    maxXor = curXor;
                    break;
                }
            }
        }
        return maxXor;
    }

    public static void main(String[] args) {
        Medium0421 main = new Medium0421();
        System.out.println(main.findMaximumXOR(
                new int[] {3, 10, 5, 25, 2, 8}
        ));
    }
}