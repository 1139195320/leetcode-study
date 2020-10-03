package com.jack.algorithm.problem.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jack
 */
public class LeetCode1542 {

    public int longestAwesome(String s) {
        int res = 0;
        char[] arr = s.toCharArray();
        // prefix, index
        Map<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, -1);
        int tmp = 0;
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            int cur = 1 << (c - '0');
            tmp ^= cur;
            if (prefixMap.containsKey(tmp)) {
                res = Math.max(res, i - prefixMap.get(tmp));
            } else {
                // 只记住这个 tmp 值出现的最早的位置
                prefixMap.put(tmp, i);
            }
            // 有可能其他都抵消，还剩一个数字的情况
            for (int j = 0; j < 10; j++) {
                int curTmp = tmp ^ (1 << j);
                if (prefixMap.containsKey(curTmp)) {
                    res = Math.max(res, i - prefixMap.get(curTmp));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode1542 main = new LeetCode1542();
        System.out.println(main.longestAwesome("3242415"));
        System.out.println(main.longestAwesome("12345678"));
        System.out.println(main.longestAwesome("213123"));
        System.out.println(main.longestAwesome("00"));
    }
}
