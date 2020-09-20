package com.jack.algorithm.problem.midium;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author jack
 *
 * 正往右，负往左，小的无，相等均无
 */
public class LeetCode0735 {

    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null || asteroids.length <= 1) {
            return asteroids;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(asteroids[0]);
        for (int i = 1; i < asteroids.length; i++) {
            int asteroid = asteroids[i];
            if (stack.empty()) {
                stack.push(asteroid);
            } else {
                while (!stack.empty()) {
                    int preAsteroid = stack.peek();
                    if (preAsteroid > 0 && asteroid < 0) {
                        // 相撞
                        if (preAsteroid > -asteroid) {
                            // 右边输了
                            break;
                        } else if (preAsteroid == -asteroid) {
                            // 同归
                            stack.pop();
                            break;
                        } else {
                            // 左边输了，如果左边还有则继续比
                            stack.pop();
                            // 左边没有了，右边入栈
                            if (stack.empty()) {
                                stack.push(asteroid);
                                break;
                            }
                        }
                    } else {
                        // 左边向左，或右边向右，不会相撞
                        stack.push(asteroid);
                        break;
                    }
                }
            }
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            res[i] = stack.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode0735 main = new LeetCode0735();
        System.out.println(Arrays.toString(main.asteroidCollision(
                new int[] {5, 10, -5}
        )));
        System.out.println(Arrays.toString(main.asteroidCollision(
                new int[] {8, -8}
        )));
        System.out.println(Arrays.toString(main.asteroidCollision(
                new int[] {10, 2, -5}
        )));
        System.out.println(Arrays.toString(main.asteroidCollision(
                new int[] {-2, -1, 1, 2}
        )));
        System.out.println(Arrays.toString(main.asteroidCollision(
                new int[] {1, -1, -2, -2}
        )));
    }
}