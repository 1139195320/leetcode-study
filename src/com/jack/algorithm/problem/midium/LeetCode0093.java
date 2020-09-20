package com.jack.algorithm.problem.midium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jack
 * 超时错误题解和官方题解
 */
public class LeetCode0093 {

    private List<String> res_back;
    private char[] arr;
    public List<String> restoreIpAddresses_back(String s) {
        res_back = new ArrayList<>();
        arr = s.toCharArray();
        dfs_back("", -1, 0, 0);
        return res_back;
    }
    private void dfs_back(String curStr, int pre,
                          int start, int dotCount) {
        if (curStr.length() >= arr.length + 4) {
            if (dotCount == 4) {
                res_back.add(curStr.substring(0,
                        curStr.length() - 1));
            }
            return;
        }
        if (dotCount >= 4) {
            return;
        }
        if (pre == 0) {
            dfs_back(curStr + pre + ".", -1,
                    start, dotCount + 1);
            return;
        }
        for (int i = start; i < arr.length; i++) {
            char cur = arr[i];
            if (pre == -1) {
                pre = 0;
            }
            int tmp = pre * 10 + (cur - '0');
            if (tmp > 255) {
                continue;
            }
            if (tmp <= 25) {
                if (tmp != 0) {
                    dfs_back(curStr, tmp, i + 1, dotCount);
                }
            }
            dfs_back(curStr + tmp + ".", -1,
                    i + 1, dotCount + 1);
        }
    }

    private static final int SEG_COUNT = 4;
    private List<String> res;
    private int[] segments;
    public List<String> restoreIpAddresses(String s) {
        segments = new int[SEG_COUNT];
        res = new ArrayList<>();
        dfs(s, 0, 0);
        return res;
    }
    private void dfs(String s, int segId, int segStart) {
        if (segId == SEG_COUNT) {
            if (segStart == s.length()) {
                StringBuilder sb = new StringBuilder(s.length() + 3);
                for (int i = 0; i < SEG_COUNT; i++) {
                    sb.append(segments[i]);
                    if (i != SEG_COUNT - 1) {
                        sb.append(".");
                    }
                }
                res.add(sb.toString());
            }
            return;
        }
        // 还没有找到 4 段，但是已经遍历完了字符串
        if (segStart == s.length()) {
            return;
        }
        if (s.charAt(segStart) == '0') {
            segments[segId] = 0;
            dfs(s, segId + 1, segStart + 1);
        }
        int tmp = 0;
        for (int segEnd = segStart; segEnd < s.length(); segEnd++) {
            tmp = tmp * 10 + (s.charAt(segEnd) - '0');
            if (tmp > 0 && tmp <= 0xFF) {
                // 只要这一段在 0-255 之间就有可能
                segments[segId] = tmp;
                dfs(s, segId + 1, segEnd + 1);
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        LeetCode0093 main = new LeetCode0093();
        System.out.println(main.restoreIpAddresses_back(
                "25525511135"
        ));
    }
}