package com.jack.algorithm.problem.pre;

import java.util.HashSet;
import java.util.Set;

/**
 * @author jack
 */
public class Medium0898 {

    public int subarrayBitwiseORs(int[] A) {
        Set<Integer> res = new HashSet<>();
        Set<Integer> cur = new HashSet<>();
        for (int x : A) {
            Set<Integer> cur2 = new HashSet<>();
            for (int y : cur) {
                cur2.add(x | y);
            }
            cur2.add(x);
            cur = cur2;
            res.addAll(cur);
        }
        return res.size();
    }

    public int subarrayBitwiseORs2(int[] A) {
        int n = A.length;
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int cur = A[i];
            res.add(cur);
            for (int j = i + 1; j < n; j++) {
                cur |= A[j];
                res.add(cur);
            }
        }
        return res.size();
    }

    public static void main(String[] args) {
        Medium0898 main = new Medium0898();
        System.out.println(main.subarrayBitwiseORs(
                new int[]{0}
        ));
        System.out.println(main.subarrayBitwiseORs(
                new int[]{1, 1, 2}
        ));
        System.out.println(main.subarrayBitwiseORs(
                new int[]{1, 2, 4}
        ));
        System.out.println();
        System.out.println(main.subarrayBitwiseORs2(
                new int[]{0}
        ));
        System.out.println(main.subarrayBitwiseORs2(
                new int[]{1, 1, 2}
        ));
        System.out.println(main.subarrayBitwiseORs2(
                new int[]{1, 2, 4}
        ));
    }
}