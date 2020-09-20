package com.jack.algorithm.problem.midium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author jack
 */
public class LeetCode0120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> pre = new ArrayList<>();
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < triangle.size(); i++) {
            List<Integer> list = triangle.get(i);
            int firstCur = list.get(0) + (pre.size() > 0 ? pre.get(0) : 0);
            List<Integer> tmp = new ArrayList<>();
            tmp.add(firstCur);
            if (i == triangle.size() - 1) {
                res = Math.min(res, firstCur);
            }
            for (int j = 1; j < list.size(); j++) {
                int cur = pre.get(j - 1) + list.get(j);
                if (j != pre.size()) {
                    cur = Math.min(pre.get(j), pre.get(j - 1)) + list.get(j);
                }
                tmp.add(cur);
                if (i == triangle.size() - 1) {
                    res = Math.min(res, cur);
                }
            }
            pre = tmp;
        }
        return res;
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }
        int[] preArr = {};
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < triangle.size(); i++) {
            List<Integer> list = triangle.get(i);
            int firstCur = list.get(0) + (preArr.length > 0 ? preArr[0] : 0);
            int[] tmpArr = new int[preArr.length + 1];
            tmpArr[0] = firstCur;
            if (i == triangle.size() - 1) {
                res = Math.min(res, firstCur);
            }
            for (int j = 1; j < list.size(); j++) {
                int cur = preArr[j - 1] + list.get(j);
                if (j != preArr.length) {
                    cur = Math.min(preArr[j], preArr[j - 1]) + list.get(j);
                }
                tmpArr[j] = cur;
                if (i == triangle.size() - 1) {
                    res = Math.min(res, cur);
                }
            }
            preArr = tmpArr;
        }
        return res;
    }

    public int minimumTotal3(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + triangle.get(i).get(i);
            for (int j = i - 1; j > 0; j --) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + triangle.get(i).get(j);
            }
            dp[0] += triangle.get(i).get(0);
        }
        int res = dp[0];
        for (int i = 1; i < n; i++) {
            res = Math.min(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0120 main = new LeetCode0120();
        System.out.println(main.minimumTotal(
                Arrays.asList(
                        Collections.singletonList(2),
                        Arrays.asList(3, 4),
                        Arrays.asList(6, 5, 7),
                        Arrays.asList(4, 1, 8, 3)
                )
        ));
    }
}