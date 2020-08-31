package com.hush.algotithm;

import java.util.Stack;

/**
 * @Author: huangshuai
 * @Date: 2020-06-22
 * @Version 1.0
 */
public class Question42 {

    /**
     * 接雨水 leetcode—42
     * @param height
     * @return
     */
    public static int trap(int[] height) {

        // 1. 动态规划，两个数组分别记录该位置左边的最大值，右边的最大值
        //    遍历数组求每个位置的雨水，相加求和
        int result = 0;
        int length = height.length;
        int[] left_max = new int[length];
        int[] right_max = new int[length];

        //左边的最高处
        for (int i = 1; i < length; i++) {
            left_max[i] = Math.max(left_max[i - 1], height[i - 1]);
        }

        //右边的最高处
        for (int j = length - 2; j > 0; j--) {
            right_max[j] = Math.max(right_max[j + 1], height[j + 1]);
        }

        for (int i = 0; i < length; i++) {
            int min = Math.min(left_max[i], right_max[i]);
            if (min > height[i]) {
                result += min - height[i];
            }
        }
        return result;
    }





    /**
     * 接雨水 leetcode—42
     * @param height
     * @return
     */
    public static int trap2(int[] height) {

        // 2. 双指针解法
        int result = 0;
        int length = height.length;
        int left_max = 0;
        int right_max = 0;
        for(int i=0,j=length-1;i<j;){

            if (height[i] < height[j]) {
                if (height[i] > left_max) {
                    left_max = height[i];
                } else {
                    result += left_max - height[i];
                }
                i++;
            } else{
                if(height[j]>right_max){
                    right_max = height[j];
                }else{
                    result += right_max-height[j];
                }
                j--;
            }
        }
        return result;
    }



    /**
     * 接雨水 leetcode—42
     * @param height
     * @return
     */
    public static int trap3(int[] height) {

        // 3. 单调栈解法
        int result = 0;
        int length = height.length;
        //return result;


        int ans = 0, current = 0;
        Stack<Integer> st = new Stack<>();
        while (current < length) {
            while (!st.empty() && height[current] > height[st.peek()]) {
                int top = st.peek();
                st.pop();
                if (st.empty()){
                    break;
                }
                int distance = current - st.peek() - 1;
                int bounded_height = Math.min(height[current], height[st.peek()]) - height[top];
                ans += distance * bounded_height;
            }
            st.push(current++);
        }
        return ans;
    }

    //reference: https://cloud.tencent.com/developer/news/433986
}
