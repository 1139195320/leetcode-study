package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode1103 {

    public int[] distributeCandies(int candies, int numPeople) {
        int[] res = new int[numPeople];
        int cur = 1;
        int i = 0;
        while (candies > 0) {
            if (cur > candies) {
                cur = candies;
            }
            res[i++ % numPeople] += cur;
            candies -= cur;
            cur ++;
        }
        return res;
    }
}
