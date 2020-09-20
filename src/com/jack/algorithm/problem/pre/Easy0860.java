package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Easy0860 {

    public boolean lemonadeChange(int[] bills) {
        int[] arr = new int[2];
        for (int bill : bills) {
            if (bill == 5) {
                arr[0] ++;
            } else if (bill == 10) {
                if (arr[0] == 0) {
                    // 手头没有 5 的
                    return false;
                }
                arr[0] --;
                arr[1] ++;
            } else {
                if (arr[0] == 0) {
                    // 手头没有 5 的
                    return false;
                }
                if (arr[1] == 0) {
                    // 手头没有 10 的
                    if (arr[0] < 3) {
                        // 且 5 的不足 3 张
                        return false;
                    }
                    arr[0] -= 3;
                } else {
                    // 优先用 10 的
                    arr[1] --;
                    arr[0] --;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Easy0860 main = new Easy0860();
        System.out.println(main.lemonadeChange(
                new int[]{5, 5, 5, 10, 20}
        ));
        System.out.println(main.lemonadeChange(
                new int[]{5, 5, 10}
        ));
        System.out.println(main.lemonadeChange(
                new int[]{5, 5, 10, 10, 20}
        ));
    }
}