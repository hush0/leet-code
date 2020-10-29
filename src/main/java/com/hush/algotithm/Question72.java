package com.hush.algotithm;

/**
 * @Author: huangshuai
 * @Date: 2020-08-27
 * @Version 1.0
 */
public class Question72 {



    public static  int minDistance(String word1, String word2) {

        int length1 = word1.length();
        int length2 = word2.length();

        int[][]  dp = new int[length1+1][length2+1];

        for (int i = 1; i <= length1; i++) {
            dp[i][0] = i;
        }

        for (int j = 1; j <= length2; j++) {
            dp[0][j] = j;
        }

        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < length2; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    dp[i+1][j+1] = Math.min(dp[i + 1][j], Math.min(dp[i][j], dp[i][j + 1])) + 1;
                }
            }
        }
        return dp[length1][length2];
    }



    public static void main(String[] args) {
        System.out.println(minDistance("hello","hello1"));
    }
}
