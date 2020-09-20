package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode1450 {

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int res = 0;
        if (startTime == null || endTime == null) {
            return 0;
        }
        int len = startTime.length;
        if (len > 0) {
            for (int i = 0; i < len; i++) {
                if (queryTime >= startTime[i]
                        && queryTime <= endTime[i]) {
                    res ++;
                }
            }
        }
        return res;
    }
}
