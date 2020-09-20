package com.jack.algorithm.problem.midium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author jack
 */
public class LeetCode0901 {

    private static class StockSpanner {
        List<Integer> data;

        public StockSpanner() {
            data = new ArrayList<>();
        }

        public int next(int price) {
            data.add(price);
            int res = 0;
            for (int i = data.size() - 1; i >= 0; i--) {
                if (data.get(i) <= price) {
                    res ++;
                } else {
                    break;
                }
            }
            return res;
        }
    }

    private static class StockSpanner2 {
        Stack<Integer> priceStack;
        Stack<Integer> weightStack;

        public StockSpanner2() {
            priceStack = new Stack<>();
            weightStack = new Stack<>();
        }

        public int next(int price) {
            int res = 1;
            while (!priceStack.empty() && priceStack.peek() <= price) {
                priceStack.pop();
                res += weightStack.pop();
            }
            priceStack.push(price);
            weightStack.push(res);
            return res;
        }
    }

    public static void main(String[] args) {
        StockSpanner obj = new StockSpanner();
        System.out.println(obj.next(100));
        System.out.println(obj.next(80));
        System.out.println(obj.next(60));
        System.out.println(obj.next(70));
        System.out.println(obj.next(60));
        System.out.println(obj.next(75));
        System.out.println(obj.next(85));
    }

}