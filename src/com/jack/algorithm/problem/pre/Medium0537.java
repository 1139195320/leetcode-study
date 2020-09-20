package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Medium0537 {

    public String complexNumberMultiply(String a, String b) {
        String[] aArr = a.split("\\+");
        String[] bArr = b.split("\\+");
        int x1 = Integer.parseInt(aArr[0]);
        int y1 = Integer.parseInt(aArr[1].substring(0, aArr[1].length() - 1));
        int x2 = Integer.parseInt(bArr[0]);
        int y2 = Integer.parseInt(bArr[1].substring(0, bArr[1].length() - 1));
        int x = x1 * x2 - y1 * y2;
        int y = x1 * y2 + x2 * y1;
        return x + "+" + y + "i";
    }

    public static void main(String[] args) {
        Medium0537 main = new Medium0537();
        System.out.println(main.complexNumberMultiply("1+1i", "1+1i"));
        System.out.println(main.complexNumberMultiply("1+-1i", "1+-1i"));
    }
}