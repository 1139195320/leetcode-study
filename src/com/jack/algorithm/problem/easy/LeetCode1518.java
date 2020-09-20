package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode1518 {

    public int numWaterBottles(int numBottles, int numExchange) {
        int res = numBottles;
        int emptyBottles = numBottles;
        while (emptyBottles >= numExchange) {
            int newBottles = emptyBottles / numExchange;
            res += newBottles;
            emptyBottles = emptyBottles % numExchange + newBottles;
        }
        return res;
    }

    public static void main(String[] args) {
        LeetCode1518 main = new LeetCode1518();
        System.out.println(main.numWaterBottles(9, 3));
        System.out.println(main.numWaterBottles(15, 4));
        System.out.println(main.numWaterBottles(5, 5));
    }
}