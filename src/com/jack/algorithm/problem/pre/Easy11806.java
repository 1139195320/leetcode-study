package com.jack.algorithm.problem.pre;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jack
 */
public class Easy11806 {

    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        move(A, B, C, A.size());
    }
    private void move(List<Integer> fromList, List<Integer> otherList,
                      List<Integer> toList, int n) {
        if (n == 1) {
            // from 里面剩余最后一个的时候就将其移到 to 里面
            toList.add(fromList.remove(fromList.size() - 1));
            return;
        }
        // 将 from 里面的 n - 1 个先移到 other 里面
        move(fromList, toList, otherList, n - 1);
        // 将 from 最上面的那个移到 to
        toList.add(fromList.remove(fromList.size() - 1));
        // 再将 other 里面的 n - 1 个移到 to 里面
        move(otherList, fromList, toList, n - 1);
    }

    public static void main(String[] args) {
        Easy11806 main = new Easy11806();
        List<Integer> A = new ArrayList<>(Arrays.asList(2, 1, 0));
        List<Integer> C = new ArrayList<>();
        main.hanota(A, new ArrayList<>(), C);
        System.out.println(C);
    }
}