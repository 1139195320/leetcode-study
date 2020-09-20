package com.jack.algorithm.problem.midium;

/**
 * @author jack
 */
public class LeetCode0273 {

    private String one(int num) {
        switch(num) {
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            case 9: return "Nine";
            default:
                return "";
        }
    }

    private String twoLessThan20(int num) {
        switch(num) {
            case 10: return "Ten";
            case 11: return "Eleven";
            case 12: return "Twelve";
            case 13: return "Thirteen";
            case 14: return "Fourteen";
            case 15: return "Fifteen";
            case 16: return "Sixteen";
            case 17: return "Seventeen";
            case 18: return "Eighteen";
            case 19: return "Nineteen";
            default:
                return "";
        }
    }

    private String ten(int num) {
        switch(num) {
            case 2: return "Twenty";
            case 3: return "Thirty";
            case 4: return "Forty";
            case 5: return "Fifty";
            case 6: return "Sixty";
            case 7: return "Seventy";
            case 8: return "Eighty";
            case 9: return "Ninety";
            default:
                return "";
        }
    }

    private String two(int num) {
        int min = 10;
        int max = 99;
        if (num > max) {
            throw new IllegalArgumentException();
        }
        if (num < min) {
            return one(num);
        }
        int x = num % 10;
        int twoTen = 20;
        int threeTen = 30;
        int fourTen = 40;
        int fiveTen = 50;
        int sixTen = 60;
        int sevenTen = 70;
        int eightTen = 80;
        int nineTen = 90;
        String res;
        if (num < twoTen) {
            res = twoLessThan20(num);
        } else if (num < threeTen) {
            res = ten(2) + " " + one(x);
        } else if (num < fourTen) {
            res = ten(3) + " " + one(x);
        } else if (num < fiveTen) {
            res = ten(4) + " " + one(x);
        } else if (num < sixTen) {
            res = ten(5) + " " + one(x);
        } else if (num < sevenTen) {
            res = ten(6) + " " + one(x);
        } else if (num < eightTen) {
            res = ten(7) + " " + one(x);
        } else if (num < nineTen) {
            res = ten(8) + " " + one(x);
        } else {
            res = ten(9) + " " + one(x);
        }
        return res.trim();
    }

    private String three(int num) {
        int min = 100;
        int max = 999;
        if (num > max) {
            throw new IllegalArgumentException();
        }
        if (num < min) {
            return two(num);
        }
        int hundred = 100;
        int x1 = num / hundred;
        int x2 = num % hundred;
        return (one(x1) + " Hundred " + two(x2)).trim();
    }

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        int billion = 1000000000;
        int million = 1000000;
        int thousand = 1000;
        int x1 = num / billion;
        int x2 = num % billion;
        StringBuilder sb = new StringBuilder();
        if (x1 > 0) {
            sb.append(one(x1)).append(" Billion ");
        }
        x1 = x2 / million;
        x2 %= million;
        if (x1 > 0) {
            sb.append(three(x1)).append(" Million ");
        }
        x1 = x2 / thousand;
        x2 %= thousand;
        if (x1 > 0) {
            sb.append(three(x1)).append(" Thousand ");
        }
        if (x2 > 0) {
            sb.append(three(x2));
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        LeetCode0273 main = new LeetCode0273();
        System.out.println(Integer.MAX_VALUE);
        System.out.println(main.numberToWords(Integer.MAX_VALUE));
        String to1 = "Twelve Thousand Three Hundred Forty Five";
        System.out.println(to1.equalsIgnoreCase(main.numberToWords(12345)));
        String to2 = "One Billion Two Hundred Thirty Four Million " +
                "Five Hundred Sixty Seven Thousand Eight Hundred Ninety One";
        System.out.println(to2.equals(main.numberToWords(1234567891)));
        System.out.println(main.numberToWords(50868));
    }
}
