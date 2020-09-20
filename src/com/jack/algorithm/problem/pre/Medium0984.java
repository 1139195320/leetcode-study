package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Medium0984 {

    public String strWithout3a3b(int A, int B) {
        // A 个 'a'，B 个 'b'
        int n = A + B;
        StringBuilder sb = new StringBuilder(n);
        while (A + B > 0) {
            if (A == B) {
                int i = Math.min(A, 2);
                sb.append(repeat('a', i));
                A -= i;
                int j = Math.min(B, 2);
                sb.append(repeat('b', j));
                B -= j;
            } else if (A > B) {
                int i = Math.min(A, 2);
                sb.append(repeat('a', i));
                A -= i;
                int j = Math.min(B, 1);
                sb.append(repeat('b', j));
                B -= j;
            } else {
                int i = Math.min(B, 2);
                sb.append(repeat('b', i));
                B -= i;
                int j = Math.min(A, 1);
                sb.append(repeat('a', j));
                A -= j;
            }
        }
        return sb.toString();
    }
    private String repeat(char c, int count) {
        if (count == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(count);
        for (int i = 0; i < count; i++) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Medium0984 main = new Medium0984();
        System.out.println(main.strWithout3a3b(1, 2));
        System.out.println(main.strWithout3a3b(4, 1));
    }
}