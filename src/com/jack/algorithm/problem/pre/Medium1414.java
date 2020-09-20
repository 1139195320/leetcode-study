package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Medium1414 {

    public int findMinFibonacciNumbers(int k) {
        int n = 44;
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 2] + arr[i - 1];
        }
        int res = 0;
        int i = n - 1;
        while (k > 0) {
            while (k < arr[i]) {
                i --;
            }
            k -= arr[i];
            i -= 2;
            res ++;
        }
        return res;
    }

    public static void main(String[] args) {
        Medium1414 main = new Medium1414();
        System.out.println(main.findMinFibonacciNumbers(7));
        System.out.println(main.findMinFibonacciNumbers(10));
        System.out.println(main.findMinFibonacciNumbers(19));
    }
}