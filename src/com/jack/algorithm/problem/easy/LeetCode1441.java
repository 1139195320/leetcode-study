package com.jack.algorithm.problem.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author jack
 */
public class LeetCode1441 {

    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int i = 1;
        for (int num : target) {
            stack.push(i);
            res.add("Push");
            while (i != num) {
                stack.pop();
                res.add("Pop");
                i ++;
                stack.push(i);
                res.add("Push");
            }
            i ++;
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode1441 main = new LeetCode1441();
        System.out.println(main.buildArray(new int[] {1, 3}, 3));
        System.out.println(main.buildArray(new int[] {1, 2, 3}, 3));
        System.out.println(main.buildArray(new int[] {1, 2}, 4));
        System.out.println(main.buildArray(new int[] {2, 3, 4}, 4));
    }
}