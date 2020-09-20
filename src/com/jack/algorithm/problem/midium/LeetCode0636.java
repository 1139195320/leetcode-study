package com.jack.algorithm.problem.midium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author jack
 */
public class LeetCode0636 {

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Integer> idStack = new Stack<>();
        String[] arr = logs.get(0).split(":");
        idStack.push(Integer.parseInt(arr[0]));
        int pre = Integer.parseInt(arr[2]);
        for (int i = 1; i < logs.size(); i ++) {
            arr = logs.get(i).split(":");
            int id = Integer.parseInt(arr[0]);
            int time = Integer.parseInt(arr[2]);
            if ("start".equals(arr[1])) {
                if (!idStack.empty()) {
                    res[idStack.peek()] += (time - pre);
                }
                idStack.push(id);
                pre = time;
            } else {
                res[id] += (time - pre + 1);
                idStack.pop();
                pre = time + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0636 main = new LeetCode0636();
        String[] arr = new String[] {
                "0:start:0",
                "1:start:2",
                "1:end:5",
                "0:end:6"
        };
        List<String> data = new ArrayList<>(Arrays.asList(arr));
        System.out.println(Arrays.toString(
                main.exclusiveTime(2, data)
        ));
    }
}