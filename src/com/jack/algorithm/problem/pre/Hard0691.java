package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Hard0691 {

    private int res;
    private boolean ending;
    public int minStickers(String[] stickers, String target) {
        res = target.length();
        ending = false;
        dfs(stickers, target, 0, 0, "");
        return ending ? res : - 1;
    }
    private void dfs(String[] stickers, String target, int start,
                     int count, String curStr) {
        if (start == target.length() - 1) {
            ending = true;
            res = Math.min(res, count);
            return;
        }
        for (int i = start; i < target.length() && !ending; i++) {
            String cur = target.substring(i, i + 1);
            if (curStr.contains(cur)) {
                curStr = curStr.replaceFirst(cur, "");
            } else {
                boolean has = false;
                for (String sticker : stickers) {
                    if (ending) {
                        break;
                    }
                    if (sticker.contains(cur)) {
                        has = true;
                        dfs(stickers, target, i,
                                count + 1, curStr + sticker);
                    }
                }
                if (!has) {
                    ending = true;
                    res = -1;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Hard0691 main = new Hard0691();
        System.out.println(main.minStickers(
                new String[]{"with", "example", "science"}, "thehat"
        ));
        System.out.println(main.minStickers(
                new String[]{"notice", "possible"}, "basicbasic"
        ));
    }
}