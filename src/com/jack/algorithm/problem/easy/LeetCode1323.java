package com.jack.algorithm.problem.easy;

/**
 * @author jack
 */
public class LeetCode1323 {

    public int maximum69Number(int num) {
        String str = num + "";
        str = str.replaceFirst("6", "9");
        return Integer.parseInt(str);
    }

    public int maximum69Number2(int num) {
        String str = num + "";
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '6') {
                arr[i] = '9';
                break;
            }
        }
        return Integer.parseInt(new String(arr));
    }

    public static void main(String[] args) {
        LeetCode1323 main = new LeetCode1323();
        System.out.println(main.maximum69Number(9669));
        System.out.println(main.maximum69Number(9996));
        System.out.println(main.maximum69Number(9999));
    }
}