package com.hush.algotithm;

import java.util.ArrayList;

/**
 * @Author: huangshuai
 * @Date: 2020-10-26
 * @Version 1.0
 */
public class Question64 {


    public static int minPathSum(int[][] grid) {

        if (grid == null) {
            return 0;
        }
        int dp[][] = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid[0].length; i++) {
            if (i == 0) {
                dp[0][0] = grid[0][0];
            } else {
                dp[0][i] = dp[0][i - 1] + grid[0][i];
            }
        }

        for (int j = 1; j < grid.length; j++) {
            dp[j][0] = dp[j - 1][0] + grid[j][0];
        }


        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }


        return dp[grid.length - 1][grid[0].length - 1];


    }


    public static void main(String[] args) {
        int[][] array = new int[][]{{1, 2, 5}, {3, 2, 1}};
        System.out.println(minPathSum(array));
    }
}
