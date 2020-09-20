package com.jack.algorithm.problem.midium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jack
 */
public class LeetCode0638 {

    public int shoppingOffers(List<Integer> price,
                              List<List<Integer>> special,
                              List<Integer> needs) {
        min = 0;
        for (int i = 0; i < needs.size(); i++) {
            min += price.get(i) * needs.get(i);
        }
        dfs(price, special, 0, needs, min);
        return min;
    }
    private int min;
    private void dfs(List<Integer> price,
                     List<List<Integer>> special,
                     int start,
                     List<Integer> needs, int money) {
        if (start >= special.size()) {
            return;
        }
        List<Integer> cur = special.get(start);
        boolean can = true;
        List<Integer> newNeeds = new ArrayList<>();
        int tmp = 0;
        for (int j = 0; j < cur.size() - 1; j++) {
            int size = cur.get(j);
            if (needs.get(j) < size) {
                // 不能选该礼包了
                can = false;
                break;
            }
            newNeeds.add(needs.get(j) - size);
            tmp += price.get(j) * size;
        }
        if (can) {
            // 可以选该礼包
            int newMoney = money - tmp + cur.get(cur.size() - 1);
            min = Math.min(min, newMoney);
            dfs(price, special, start, newNeeds,
                    newMoney);
        }
        // 不选该礼包
        dfs(price, special, start + 1, needs, money);
    }

    public static void main(String[] args) {
        LeetCode0638 main = new LeetCode0638();
        System.out.println(main.shoppingOffers(
                Arrays.asList(2, 5),
                Arrays.asList(
                        Arrays.asList(3,0,5),
                        Arrays.asList(1,2,10)),
                Arrays.asList(3, 2)
        ));
        System.out.println(main.shoppingOffers(
                Arrays.asList(2,3,4),
                Arrays.asList(
                        Arrays.asList(1,1,0,4),
                        Arrays.asList(2,2,1,9)),
                Arrays.asList(1,2,1)
        ));
    }
}