package com.jack.algorithm.problem.midium;

import java.util.*;

/**
 * @author jack
 */
public class LeetCode1452 {

    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Integer> res = new ArrayList<>();
        int n = favoriteCompanies.size();
        for (int i = 0; i < n; i++) {
            List<String> favoriteCompanie = favoriteCompanies.get(i);
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                List<String> curList = favoriteCompanies.get(j);
                if (curList.size() <= favoriteCompanie.size()) {
                    continue;
                }
                Set<String> set = new HashSet<>(curList);
                if (set.containsAll(favoriteCompanie)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode1452 main = new LeetCode1452();
        System.out.println(main.peopleIndexes(
                Arrays.asList(
                        Arrays.asList("leetcode","google","facebook"),
                        Arrays.asList("google","microsoft"),
                        Arrays.asList("google","facebook"),
                        Collections.singletonList("google"),
                        Collections.singletonList("amazon")
                )
        ));
        System.out.println(main.peopleIndexes(
                Arrays.asList(
                        Arrays.asList("leetcode","google","facebook"),
                        Arrays.asList("leetcode","amazon"),
                        Arrays.asList("facebook","google")
                )
        ));
        System.out.println(main.peopleIndexes(
                Arrays.asList(
                        Collections.singletonList("leetcode"),
                        Collections.singletonList("amazon"),
                        Collections.singletonList("facebook")
                )
        ));
    }
}