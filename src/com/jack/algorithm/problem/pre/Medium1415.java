package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Medium1415 {

    private String res;
    private int n;
    private int k;
    public String getHappyString(int n, int k) {
        char[] arr = new char[]{'a', 'b', 'c'};
        this.n = n;
        this.k = k;
        res = "";
        dfs(arr, "", ' ');
        return res;
    }

    private void dfs(char[] arr, String curStr, char pre) {
        if (curStr.length() == n) {
            k --;
            if (k == 0) {
                res = curStr;
            }
            return;
        }
        for (char cur : arr) {
            if (cur == pre) {
                continue;
            }
            if (k == 0) {
                break;
            }
            dfs(arr, curStr + cur, cur);
        }
    }

    public static void main(String[] args) {
        Medium1415 main = new Medium1415();
        System.out.println(main.getHappyString(1, 3));
        System.out.println(main.getHappyString(1, 4));
        System.out.println(main.getHappyString(3, 9));
        System.out.println(main.getHappyString(2, 7));
        System.out.println(main.getHappyString(10, 100));
    }
}