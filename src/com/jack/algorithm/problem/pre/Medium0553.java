package com.jack.algorithm.problem.pre;

/**
 * @author jack
 */
public class Medium0553 {

    public String optimalDivision(int[] nums) {
        if (nums.length == 1) {
            return String.valueOf(nums[0]);
        }
        if (nums.length == 2) {
            return nums[0] + "/" + nums[1];
        }
        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]).append("/(");
        for (int i = 1; i < nums.length; i++) {
            sb.append(nums[i]);
            if (i != nums.length - 1) {
                sb.append("/");
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public static void main(String[] args) {
        Medium0553 main = new Medium0553();
        System.out.println(main.optimalDivision(
                new int[]{1000, 100, 10, 2}
        ));
    }
}