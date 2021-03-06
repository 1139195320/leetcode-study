package com.jack.algorithm.problem.still;


/**
 * @author jack
 */
public class Medium0918 {

    public int maxSubarraySumCircular(int[] A) {
        int l = 0, r = 1, cur = A[l];
        int res = cur;
        int n = A.length;
        while (r < (n << 1)) {
            if (l + n <= r) {
                // 超过了最长长度
                cur -= A[l % n];
                l++;
            }
            while (l < r && A[l % n] <= 0) {
                cur -= A[l % n];
                l++;
            }
            cur += A[r % n];
            if (l < r && cur <= 0) {
                cur = 0;
                l = r + 1;
            }
            res = Math.max(res, cur);
            r ++;
        }
        return res;
    }



    public int maxSubarraySumCircular3(int[] arr) {
        int n = arr.length;
        int res = arr[0];
        for (int i = 0; i < n; i++) {
            int cur = 0;
            for (int j = i; j < i + n; j++) {
                cur += arr[j % n];
                res = Math.max(res, cur);
            }
        }
        return res;
    }


    public int maxSubarraySumCircular2(int[] arr) {
        int start = 0;
        int l = start, r = start + 1, cur = arr[start];
        int res = cur;
        int n = arr.length;
        while (r < (n << 1)) {
            while (l < r && arr[l % n] <= 0) {
                // 把最左边的小于 0 的给减掉
                cur -= arr[l % n];
                l++;
            }
            // 应该把左边小于 0 的，最小的一段截掉
            if (l < r) {
                int leftMin = 1;
                int t = l;
                int i = l;
                int tmp = 0;
                while (i < r) {
                    tmp += arr[i % n];
                    if (tmp <= leftMin) {
                        leftMin = tmp;
                        t = i;
                    }
                    i ++;
                }
                if (leftMin <= 0) {
                    cur -= leftMin;
                    l = t + 1;
                }
            }
            // 最终此时的值
            cur += arr[r % n];
            res = Math.max(res, cur);
            r ++;
            if (r - l >= n) {
                // 已选中所有，减去最左边的一个
                cur -= arr[l % n];
                l ++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Medium0918 main = new Medium0918();
//        main.test1();
        main.test2();
    }

    private void test2() {
        System.out.println(maxSubarraySumCircular2(
                new int[]{1, 2, 3, 4}
        ));
        System.out.println(maxSubarraySumCircular2(
                new int[]{-5, -2, 5, 6, -2, -7, 0, 2, 8}
        ));
        System.out.println(maxSubarraySumCircular2(
                new int[]{0, 5, 8, -9, 9, -7, 3, -2}
        ));
        System.out.println(maxSubarraySumCircular2(
                new int[]{1, -2, 3, -2}
        ));
        System.out.println(maxSubarraySumCircular2(
                new int[]{5, -3, 5}
        ));
        System.out.println(maxSubarraySumCircular2(
                new int[]{3, -1, 2, -1}
        ));
        System.out.println(maxSubarraySumCircular2(
                new int[]{3, -2, 2, -3}
        ));
        System.out.println(maxSubarraySumCircular2(
                new int[]{-2, -3, -1}
        ));
        System.out.println(maxSubarraySumCircular2(
                new int[]{52,183,124,154,-170,-191,-240,107,-178,171,75,186,-125,61,-298,284,21,-73,-294,253,146,248,-248,127,26,289,118,-22,-300,26,-116,-113,-44,29,252,-278,47,254,-106,246,-275,42,257,15,96,-298,-69,-104,-239,-95,-4,76,-202,156,-14,-178,188,-84,78,-195,-125,28,109,125,-25,-53,58,287,55,-296,198,281,53,-160,146,298,25,-41,-3,27,-242,169,287,-281,19,91,213,115,211,-218,124,-25,-272,278,296,-177,-166,-192,97,-49,-25,168,-81,6,-94,267,293,146,-1,-258,256,283,-156,197,28,78,267,-151,-230,-66,100,-94,-66,-123,121,-214,-182,187,65,-186,215,273,243,-99,-76,178,59,190,279,300,217,67,-117,170,163,153,-37,-147,-251,296,-176,117,68,258,-159,-300,-36,-91,-60,195,-293,-116,208,175,-100,-97,188,79,-270,80,100,211,112,264,-217,-142,5,105,171,-264,-247,138,275,227,-86,30,-219,153,10,-66,267,22,-56,-70,-234,-66,89,182,110,-146,162,-48,-201,-240,-225,-15,-275,129,-117,28,150,84,-264,249,-85,70,-140,-259,26,162,5,-203,143,184,101,140,207,131,177,274,-178,-79,14,-36,104,52,31,257,273,-52,74,276,104,-133,-255,188,-252,229,200,-74,-39,-250,142,-201,-196,-43,-40,255,-149,-299,-197,-175,-96,-155,-196,-24,12,79,71,-144,-59,-120,227,-256,-163,-297,116,286,-283,-31,-221,-41,121,-170,160,205,8,88,25,-272,-107,292,-180,299,94,-97,-81,-134,37,238}
        ));
    }

    private void test1() {
        System.out.println(maxSubarraySumCircular(
                new int[]{-5, -2, 5, 6, -2, -7, 0, 2, 8}
        ));
        System.out.println(maxSubarraySumCircular(
                new int[]{0, 5, 8, -9, 9, -7, 3, -2}
        ));
        System.out.println(maxSubarraySumCircular(
                new int[]{1, -2, 3, -2}
        ));
        System.out.println(maxSubarraySumCircular(
                new int[]{5, -3, 5}
        ));
        System.out.println(maxSubarraySumCircular(
                new int[]{3, -1, 2, -1}
        ));
        System.out.println(maxSubarraySumCircular(
                new int[]{3, -2, 2, -3}
        ));
        System.out.println(maxSubarraySumCircular(
                new int[]{-2, -3, -1}
        ));
        System.out.println(maxSubarraySumCircular(
                new int[]{52,183,124,154,-170,-191,-240,107,-178,171,75,186,-125,61,-298,284,21,-73,-294,253,146,248,-248,127,26,289,118,-22,-300,26,-116,-113,-44,29,252,-278,47,254,-106,246,-275,42,257,15,96,-298,-69,-104,-239,-95,-4,76,-202,156,-14,-178,188,-84,78,-195,-125,28,109,125,-25,-53,58,287,55,-296,198,281,53,-160,146,298,25,-41,-3,27,-242,169,287,-281,19,91,213,115,211,-218,124,-25,-272,278,296,-177,-166,-192,97,-49,-25,168,-81,6,-94,267,293,146,-1,-258,256,283,-156,197,28,78,267,-151,-230,-66,100,-94,-66,-123,121,-214,-182,187,65,-186,215,273,243,-99,-76,178,59,190,279,300,217,67,-117,170,163,153,-37,-147,-251,296,-176,117,68,258,-159,-300,-36,-91,-60,195,-293,-116,208,175,-100,-97,188,79,-270,80,100,211,112,264,-217,-142,5,105,171,-264,-247,138,275,227,-86,30,-219,153,10,-66,267,22,-56,-70,-234,-66,89,182,110,-146,162,-48,-201,-240,-225,-15,-275,129,-117,28,150,84,-264,249,-85,70,-140,-259,26,162,5,-203,143,184,101,140,207,131,177,274,-178,-79,14,-36,104,52,31,257,273,-52,74,276,104,-133,-255,188,-252,229,200,-74,-39,-250,142,-201,-196,-43,-40,255,-149,-299,-197,-175,-96,-155,-196,-24,12,79,71,-144,-59,-120,227,-256,-163,-297,116,286,-283,-31,-221,-41,121,-170,160,205,8,88,25,-272,-107,292,-180,299,94,-97,-81,-134,37,238}
        ));
    }
}