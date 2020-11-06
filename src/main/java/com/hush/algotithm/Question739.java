package com.hush.algotithm;

import java.util.Stack;

/**
 * @Author: huangshuai
 * @Date: 2020-11-04
 * @Version 1.0
 */
public class Question739 {


    /**
     * 普通双循环 复杂度O(m*n)
     * @param T
     * @return
     */
    public int[] dailyTemperatures(int[] T) {

        int length = T.length;
        int[] result =  new int[length];

        for(int i=0;i<length;i++){
            for(int j=i+1;j<=length;j++){
                if(j==length){
                    result[i] = 0;
                    break;
                }
                if(T[j]>T[i]){
                    result[i] = j-i;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 单调栈实现 复杂度O(n)
     * @param T
     * @return
     */
    public int[] dailyTemperatures1(int[] T) {
        int[] result = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && T[stack.peek()] < T[i]) {

                    result[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }

        }
        return result;

    }


}
