package com.jack.algorithm.problem.pre;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jack
 */
public class Medium0842 {

    private List<Integer> res;
    private boolean find;
    public List<Integer> splitIntoFibonacci(String S) {
        res = new ArrayList<>();
        find = false;
        dfs(S, 0);
        return res;
    }
    private void dfs(String S, int start) {
        if (start == S.length() && res.size() > 2) {
            find = true;
            return;
        }
        int pre = -1;
        for (int i = start; i < S.length(); i++) {
            if (pre == 0) {
                break;
            }
            int cur = Integer.parseInt(S.substring(start, i + 1));
            if (res.size() >= 2) {
                int preSum = res.get(res.size() - 1) + res.get(res.size() - 2);
                if (cur < preSum) {
                    continue;
                } else if (cur > preSum) {
                    return;
                }
            }
            res.add(cur);
            dfs(S, i + 1);
            if (find) {
                break;
            }
            res.remove(res.size() - 1);
            pre = cur;
        }
    }

    public static void main(String[] args) {
        Medium0842 main = new Medium0842();
        System.out.println(main.splitIntoFibonacci("123456579"));
        System.out.println(main.splitIntoFibonacci("11235813"));
        System.out.println(main.splitIntoFibonacci("112358130"));
        System.out.println(main.splitIntoFibonacci("0123"));
        System.out.println(main.splitIntoFibonacci("1101111"));
    }
}