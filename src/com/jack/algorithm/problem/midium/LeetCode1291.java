package com.jack.algorithm.problem.midium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author jack
 */
public class LeetCode1291 {

    public static void main(String[] args) {
        LeetCode1291 main = new LeetCode1291();
        System.out.println(main.sequentialDigits(100 ,300));
        System.out.println(main.sequentialDigits(1000 ,13000));
    }

    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        int len = 0;
        int tmp = low;
        int divisor = 1;
        while (tmp > 0) {
            len ++;
            tmp /= 10;
            divisor *= 10;
        }
        divisor /= 10;
        // 判断最高位
        if (len + low / divisor <= 10) {
            int adder = getAdder(len);
            int num = getNum(len, low / divisor);
            while (num % 10 < 9 && num < high) {
                if (num >= low) {
                    res.add(num);
                }
                num += adder;
            }
            if (num >= low && num <= high) {
                res.add(num);
            }
        }
        int num = getNum(++ len, 1);
        int adder = getAdder(len);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(num);
        while (num % 10 < 9 && num <= high) {
            num += adder;
            queue.add(num);
        }
        while (!queue.isEmpty() && queue.peek() <= high) {
            int cur = queue.remove();
            if (cur < high) {
                res.add(cur);
                if (cur % 10 != 9) {
                    queue.add(cur * 10 + cur % 10 + 1);
                }
            }
        }
        return res;
    }
    private int getNum(int len, int fc) {
        int res = fc;
        while (len > 1) {
            fc ++;
            res = res * 10 + fc;
            len --;
        }
        return res;
    }
    private int getAdder(int len) {
        int res = 1;
        while (len > 1) {
            res = res * 10 + 1;
            len --;
        }
        return res;
    }
}