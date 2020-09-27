package com.jack.algorithm.problem.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jack
 */
public class LeetCode0466 {

    /**
     * 统计重复个数
     * 方法：找出循环节
     */
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if (n1 == 0) {
            return 0;
        }
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int l1 = s1.length();
        int l2 = s2.length();
        // 经历多少s1
        int countS1 = 0;
        // 经历多少s2
        int countS2 = 0;
        // 当前在s2的位置
        int p = 0;
        // 记录每一次s1扫描结束后当前的状态，寻找循环
        Map<Integer, int[]> mp = new HashMap<>();
        while (countS1 < n1) {
            for (int i = 0; i < l1; i++) {
                if (c1[i] == c2[p]) {
                    // 往前
                    p++;
                    if (p == l2) {
                        // s2扫描结束从头开始循环
                        p = 0;
                        countS2++;
                    }
                }
            }
            countS1++;
            if (!mp.containsKey(p)) {
                // 记录当前状态
                mp.put(p, new int[]{countS1, countS2});
            } else {
                // 出现了循环 这次结束后p的位置和以前某一次一样，就是循环
                int[] last = mp.get(p);
                int circle1 = countS1 - last[0];
                int circle2 = countS2 - last[1];
                countS2 += circle2 * ((n1 - countS1) / circle1);
                // 更新
                countS1 = countS1 + ((n1 - countS1) / circle1) * circle1;
            }
        }
        return countS2 / n2;
    }

    public static void main(String[] args) {
        LeetCode0466 main = new LeetCode0466();
        System.out.println(
                main.getMaxRepetitions("acb", 4, "ab", 2));
        System.out.println(
                main.getMaxRepetitions("acb", 1, "acb", 1));
        System.out.println(
                main.getMaxRepetitions("aaa", 3, "aa", 1));
        System.out.println(
                main.getMaxRepetitions("aaa", 20, "aaaaa", 1));
    }
}
