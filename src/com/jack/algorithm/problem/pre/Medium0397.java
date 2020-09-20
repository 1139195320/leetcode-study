package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Medium0397 {

    public int integerReplacement(int n) {
        if (n <= 1) {
            return 0;
        }
        int count = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
            }
            count ++;
        }
        return count;
    }

    public static void main(String[] args) {
        Medium0397 main = new Medium0397();
        System.out.println(main.integerReplacement(8));
        System.out.println(main.integerReplacement(7));
        System.out.println(main.integerReplacement(6));
        System.out.println(main.integerReplacement(5));
    }
}