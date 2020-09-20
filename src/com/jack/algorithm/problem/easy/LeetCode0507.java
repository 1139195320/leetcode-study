package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode0507 {

    public static void main(String[] args) {
        LeetCode0507 main = new LeetCode0507();
        System.out.println(main.checkPerfectNumber(28));
        System.out.println(main.checkPerfectNumber(25));
        System.out.println(main.checkPerfectNumber2(28));
        System.out.println(main.checkPerfectNumber2(25));
    }

    public boolean checkPerfectNumber(int num) {
        if (num < 2) {
            return false;
        }
        int sum = 1;
        for (int i = 2; i < num / 2 + 1; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        return num == sum;
    }


    private int f(int n) {
        return (1 << (n - 1)) * ((1 << n) - 1);
    }
    public boolean checkPerfectNumber2(int num) {
        int[] primes = new int[] {2, 3, 5, 7, 13, 17, 19, 23, 29, 31};
        for (int prime : primes) {
            int tmp = f(prime);
            if (tmp == num) {
                return true;
            } else if (tmp > num){
                break;
            }
        }
        return false;
    }
}