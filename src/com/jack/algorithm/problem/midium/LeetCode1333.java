package com.jack.algorithm.problem.midium;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jack
 */
public class LeetCode1333 {

    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        return Arrays.stream(restaurants).filter(
                arr -> (veganFriendly == 0 || arr[2] == veganFriendly)
                        && arr[3] <= maxPrice && arr[4] <= maxDistance
        ).sorted(
                (arr1, arr2) -> {
                    if (arr2[1] > arr1[1]) {
                        return 1;
                    } else if (arr2[1] == arr1[1]) {
                        // rating 相等
                        return arr2[0] >= arr1[0] ? 1 : -1;
                    } else {
                        return -1;
                    }
                }
        ).map(arr -> arr[0]).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        LeetCode1333 main = new LeetCode1333();
        System.out.println(main.filterRestaurants(
                new int[][]{
                        {1, 4, 1, 40, 10},
                        {2, 8, 0, 50, 5},
                        {3, 8, 1, 30, 4},
                        {4, 10, 0, 10, 3},
                        {5, 1, 1, 15, 1}
                }, 1, 50, 10
        ));
    }
}
