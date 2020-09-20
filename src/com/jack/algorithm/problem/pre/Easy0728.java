package com.jack.algorithm.problem.pre;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jack
 */
public class Easy0728 {

    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            int cur = i;
            boolean flag = true;
            while (cur > 0) {
                int tmp = cur % 10;
                if (tmp == 0) {
                    flag = false;
                    break;
                }
                if (i % tmp != 0) {
                    flag = false;
                    break;
                }
                cur /= 10;
            }
            if (flag) {
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Easy0728 main = new Easy0728();
        System.out.println(main.selfDividingNumbers(1, 22));
    }
}