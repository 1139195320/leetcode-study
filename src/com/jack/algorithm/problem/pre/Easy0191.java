package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Easy0191 {

    public int hammingWeight(int n) {
        // you need treat n as an unsigned value
        String src = Integer.toBinaryString(n);
        int res = 0;
        for (int i = 0; i < src.length(); i++) {
            res += (src.charAt(i) - '0');
        }
        return res;
    }

    public int hammingWeight2(int n) {
        // you need treat n as an unsigned value
        return Integer.bitCount(n);
    }

    public static void main(String[] args) {
        Easy0191 main = new Easy0191();
        System.out.println(main.hammingWeight(11));
        System.out.println(main.hammingWeight2(11));
    }
}