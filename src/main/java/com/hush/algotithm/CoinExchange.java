package com.hush.algotithm;

import java.util.Arrays;

/**
 * @Author: huangshuai
 * @Date: 2020-08-11
 * @Version 1.0
 */
public class CoinExchange {

    public static void main(String[] args) {

        int[] coins={186,419,83,408};
        int amount = 6249;
        Arrays.sort(coins);
        int result= coinExchangeRecursion(amount,coins.length,coins);
        if(result==0){
            System.out.println(-1);
        }
        System.out.println(counter(amount,coins.length,coins));
    }



    public static int coinExchangeRecursion(int amount,int m, int[] coins){
        if(amount ==0){
            return 1;
        }
        if(amount<0 || m==0){
            return 0;
        }
        return coinExchangeRecursion(amount,m-1,coins)+coinExchangeRecursion(amount-coins[m-1] ,m,coins);
    }


    public static int counter(int amount,int m, int[] coins){
        int count =0;
        while(amount>0&& m>0){
            if(coinExchangeRecursion(amount-coins[m-1],m,coins)>0){
                count++;
                amount=amount-coins[m-1];
            }else{
                m--;
            }
        }
        return count;
    }
}
