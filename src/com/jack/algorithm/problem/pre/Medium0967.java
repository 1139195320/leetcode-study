package com.jack.algorithm.problem.pre;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jack
 */
public class Medium0967 {

    public int[] numsSameConsecDiff(int N, int K) {
        resList = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            dfs(N - 1, K, 0, i);
        }
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }
    private List<Integer> resList;
    private void dfs(int n, int K, int preNum, int cur) {
        preNum = preNum * 10 + cur;
        if (n == 0) {
            resList.add(preNum);
            return;
        }
        if (cur - K >= 0) {
            dfs(n - 1, K, preNum, cur - K);
        }
        if (cur + K <= 9) {
            dfs(n - 1, K, preNum, cur + K);
        }
    }

    public static void main(String[] args) {
        Medium0967 main = new Medium0967();
        System.out.println(Arrays.toString(main.numsSameConsecDiff(3, 7)));
        System.out.println(Arrays.toString(main.numsSameConsecDiff(2, 1)));
    }
}