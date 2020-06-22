package com.hush.algotithm;

/**
 * @Author: huangshuai
 * @Date: 2020-06-22
 * @Version 1.0
 */
public class Question11 {

    public int maxArea(int[] height) {
        int water = 0;
        int i = 0, j = height.length - 1;
        while (i < j)
        {
            int h = height[i] <= height[j] ? height[i] : height[j];
            if(((j - i) * h) > water){
                water = (j - i) * h;
            }
            while (height[i] <= h && i < j) i++;
            while (height[j] <= h && i < j) j--;
        }
        return water;

    }
}
