package com.hush.algotithm;

import java.util.Arrays;

/**
 * @Author: huangshuai
 * @Date: 2020-08-27
 * @Version 1.0
 */
public class Question55 {


    /**
     * 跳跃游戏 leetcode-55
     * @param nums
     * @return
     */
    public static  boolean canJump(int[] nums) {


        int length = nums.length;
        int[] dp = new int[length];
        Arrays.fill(dp, 0);

        if(nums[0]>0 || nums.length ==1){
            dp[0]=1;
        }
        for (int i = 0; i < length-1; i++) {
            if(nums[i]<=0){
                continue;
            }
            for (int j = i + 1; j <= i + nums[i] && dp[i] == 1 && j < length; j++) {
                dp[j] = 1;
            }
        }
        return dp[length-1] == 1;
    }


    /**
     * 贪心算法
     * @param nums
     * @return
     */
    public static  boolean canJump1(int[] nums) {
        int n = nums.length - 1;
        int dist = 0;
        for (int i = 0; i <= n; i++) {
            if (dist < i || dist >= n) break;
            dist =  Math.max(dist, i + nums[i]);
        }
        return dist >= n;
    }




    public static void main(String[] args) {

        int[] array = {3,2,2,0,4};
        System.out.println(canJump(array));

    }
}
