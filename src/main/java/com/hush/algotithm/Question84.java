package com.hush.algotithm;

/**
 * @Author: huangshuai
 * @Date: 2020-10-29
 * @Version 1.0
 */
public class Question84 {

    public static int largestRectangleArea(int[] heights) {

        int result = 0;
        int length = heights.length;
        for (int i = 0; i < length; i++) {
            int count = 1;
            for(int j = i-1;j>=0;j--){
                if(heights[j]>= heights[i]){
                    count ++;
                } else {
                    break;
                }
            }
            for(int k = i+1;k<length;k++){
                if(heights[k]>= heights[i]){
                    count ++;
                } else {
                    break;
                }
            }
            int area = heights[i]*count;
            if(area>result){
                result = area;
            }
        }

        return result;

    }

    public static void main(String[] args) {

    }
}
