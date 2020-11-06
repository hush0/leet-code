package com.hush.algotithm;

/**
 * @Author: huangshuai
 * @Date: 2020-10-29
 * @Version 1.0
 */
public class Question121 {


    /**
     * 暴力破解
     * @param prices
     * @return
     */
    public static int maxProfit1(int[] prices) {
        int result = 0;
        int length = prices.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                 if(prices[i]<prices[j] && prices[j]-prices[i]>result){
                     result = prices[j]-prices[i];
                 }
            }
        }
        return result;
    }



    public static int maxProfit(int[] prices) {

        int result = 0;
        int length = prices.length;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {

            if(prices[i]<minPrice){
                minPrice = prices[i];
            }
            if(prices[i] - minPrice > result){
                result = prices[i] - minPrice;
            }

        }
        return result;


    }


    //TODO  单调栈实现



    public static void main(String[] args) {
        int[] nums = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(nums));
    }
}
