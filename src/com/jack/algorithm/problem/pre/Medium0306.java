package com.jack.algorithm.problem.pre;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jack
 */
public class Medium0306 {

    private boolean res;
    public boolean isAdditiveNumber(String num) {
        res = false;
        dfs(num, new ArrayList<>(), 0);
        return res;
    }
    private void dfs(String num, List<Long> curList, int start) {
        if (curList.size() >= 3 && start == num.length()) {
            System.out.println(curList);
            res = true;
            return;
        }
        for (int i = start + 1; i <= num.length(); i++) {
            if (res) {
                break;
            }
            long cur = Long.valueOf(num.substring(start, i));
            if (curList.size() >= 2
                    && cur != curList.get(curList.size() - 1)
                    + curList.get(curList.size() - 2)) {
                continue;
            }
            curList.add(cur);
            dfs(num, curList, i);
            curList.remove(curList.size() - 1);
        }
    }

    public static void main(String[] args) {
        Medium0306 main = new Medium0306();
        System.out.println(main.isAdditiveNumber("112358"));
        System.out.println(main.isAdditiveNumber("199100199"));
    }
}