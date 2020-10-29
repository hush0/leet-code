package com.hush.algotithm;

/**
 * @Author: huangshuai
 * @Date: 2020-07-09
 * @Version 1.0
 */
public class Offer10 {


    public static int numWays(int n) {
        if (n <= 1) {
            return 1;
        } else {
            int i=2;
            int temp1 = 1;
            int temp2 = 1;
            while(i<=n){
                int temp = (temp1+temp2)% 1000000007;
                temp1 = temp2;
                temp2 = temp;
                i++;
            }
            return temp2;
        }
    }



    public static void main(String[] args) {
        System.out.println(numWays(46));
    }
}
