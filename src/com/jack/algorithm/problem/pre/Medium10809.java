package com.jack.algorithm.problem.pre;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jack
 */
public class Medium10809 {

    private List<String> res;
    private int n;
    public List<String> generateParenthesis(int n) {
        this.n = n;
        res = new ArrayList<>();
        dfs("", 0, 0);
        return res;
    }

    private void dfs(String pre, int lCount, int rCount) {
        if (lCount == n && rCount == n) {
            res.add(pre);
            return;
        }
        if (rCount > lCount) {
            return;
        }
        if (lCount < n) {
            dfs(pre + "(", lCount + 1, rCount);
        }
        dfs(pre + ")", lCount, rCount + 1);
    }

    public static void main(String[] args) {
        Medium10809 main = new Medium10809();
        System.out.println(main.generateParenthesis(3));
    }
}