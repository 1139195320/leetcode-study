package com.jack.algorithm.problem.midium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jack
 */
public class LeetCode0089 {

    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        int count = (int) Math.pow(2, n);
        for (int i = 0; i < count; i++) {
            res.add(i ^ (i >> 1));
        }
        return res;
    }

    public List<Integer> grayCode2(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        for (int i = 0; i < n; i++) {
            // 要加的数
            int add = 1 << i;
            // 倒序遍历
            for (int j = res.size() - 1; j >= 0; j--) {
                res.add(res.get(j) + add);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0089 main = new LeetCode0089();
        System.out.println(main.grayCode(0));
        System.out.println(main.grayCode(2));
        System.out.println(main.grayCode(4));
    }
}