package com.jack.algorithm.problem.hard;

import java.util.Stack;

/**
 * @author jack
 */
public class LeetCode0042 {

    public int trap(int[] heights) {
        if (heights == null || heights.length < 3) {
            return 0;
        }
        int maxHeight = -1;
        int maxIndex = -1;
        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            if (height > maxHeight) {
                maxHeight = height;
                maxIndex = i;
            }
        }
        int res = 0;
        int curMaxHeight = 0;
        for (int i = 0; i < maxIndex; i++) {
            int height = heights[i];
            if (height > curMaxHeight) {
                curMaxHeight = height;
            } else {
                res += (curMaxHeight - height);
            }
        }
        curMaxHeight = 0;
        for (int i = heights.length - 1; i > maxIndex; i--) {
            int height = heights[i];
            if (height > curMaxHeight) {
                curMaxHeight = height;
            } else {
                res += (curMaxHeight - height);
            }
        }
        return res;
    }


    public int trap2(int[] heights) {
        int res = 0;
        int cur = 0;
        if (heights != null && heights.length > 2) {
            Stack<Integer> stack = new Stack<>();
            while (cur < heights.length) {
                while (!stack.empty()
                        && heights[cur] > heights[stack.peek()]) {
                    int top = stack.pop();
                    if (stack.empty()) {
                        break;
                    }
                    // 距离
                    int dis = cur - stack.peek() - 1;
                    int durHeight = Math.min(heights[cur],
                            heights[stack.peek()]) - heights[top];
                    res += dis * durHeight;
                }
                stack.push(cur ++);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0042 main = new LeetCode0042();
        main.testTrap();
        System.out.println("////////////////");
        main.testTrap2();
    }

    private void testTrap() {
        // 0 + 1 + 0 + 0 + 1 + 2 + 1 + 0 + 0 + 1 + 0 + 0 = 6
        System.out.println(trap(new int[]{
                0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1
        }));
        // 0 + 0 + 0 + 1 + 2 + 3 + 2 + 0 + 0 + 1 + 0 + 0 = 9
        System.out.println(trap(new int[]{
                0, 1, 3, 2, 1, 0, 1, 3, 2, 1, 2, 1
        }));
        // 0 + 2 + 0 + 1 + 2 + 3 + 2 + 0 + 0 + 1 + 0 + 0 = 11
        System.out.println(trap(new int[]{
                4, 1, 3, 2, 1, 0, 1, 3, 2, 1, 2, 1
        }));
    }

    private void testTrap2() {
        // 0 + 1 + 0 + 0 + 1 + 2 + 1 + 0 + 0 + 1 + 0 + 0 = 6
        System.out.println(trap2(new int[]{
                0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1
        }));
        // 0 + 0 + 0 + 1 + 2 + 3 + 2 + 0 + 0 + 1 + 0 + 0 = 9
        System.out.println(trap2(new int[]{
                0, 1, 3, 2, 1, 0, 1, 3, 2, 1, 2, 1
        }));
        // 0 + 2 + 0 + 1 + 2 + 3 + 2 + 0 + 0 + 1 + 0 + 0 = 11
        System.out.println(trap2(new int[]{
                4, 1, 3, 2, 1, 0, 1, 3, 2, 1, 2, 1
        }));
    }
}
