package com.hush.algotithm;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author: huangshuai
 * @Date: 2020-08-27
 * @Version 1.0
 */
public class Question70 {

    public static int climbStairs(int n) {
        int i = 1;
        int temp0 = 1;
        int temp1 = 1;
        while (i < n) {
            int temp = temp0 + temp1;
            temp0 = temp1;
            temp1 = temp;
            i++;
        }
        return temp1;
    }





    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
}
