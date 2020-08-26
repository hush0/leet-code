package com.hush.algotithm;


import com.sun.xml.internal.ws.util.StringUtils;

import java.util.*;

/**
 * @Author: huangshuai
 * @Date: 2020-06-22
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("This is a gradle project!");

        /*RateLimiter rateLimiter = new RateLimiter(100, 2);
        for (; true; ) {
            if (rateLimiter.acquire()) {
                System.out.println("acquire success, " + new Date());
            } else {
                try {
                    System.out.println("for waiting ");
                    Thread.sleep(50);
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }


        Set<Character> set = new HashSet<>();
        String str = " ";
        str = str.trim();
        System.out.println("**" + str + "**");*/
        //set.add(str.charAt(2));


       /*int length =  lengthOfLongestSubstring(" ");
        System.out.println(length);*/

        /*int[] nums1 = {1, 2};
        int[] nums2 = {3};
        Double result = findMedianSortedArrays(nums1, nums2);
        System.out.println(result);*/


        //System.out.println(convert("123456789abcde",3));

        //System.out.println(myAtoi("2147483648"));

        //System.out.println(isPalindrome(12321));

        //int[] array = {1,8,6,2,5,4,8,3,7};
        //System.out.println(maxArea(array));

        //String[] array ={"aa","a"};
        //System.out.println(longestCommonPrefix(array));


        int[] array ={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(array));

    }








    /**
     * 接雨水 leetcode—42
     * @param height
     * @return
     */
    public static int trap(int[] height) {


        // 1. 动态规划，两个数组分别记录该位置左边的最大值，右边的最大值
        //    遍历数组求每个位置的雨水，相加求和
        /*int result = 0;
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
        }*/


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
     * 三数之和 leetcode_15
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        if(nums == null||nums.length<3){
            return result;
        }
        Arrays.sort(nums);
        for(int i=0;i<length;i++){
            //第一个数大于0，数组顺序递增，三数之和大于0
            if(nums[i]>0){
                break;
            }
            // 去重
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            int L = i + 1;
            int R = length - 1;
            while (L < R) {
                int sum = nums[i]+nums[L]+nums[R];
                if(sum==0){
                    result.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L < R && nums[L]==nums[L+1]){
                        L++;
                    }
                    while (L < R && nums[R]==nums[R-1]){
                        R--;
                    }
                    L++;
                    R--;
                }else if(sum<0){
                    L++;
                }else if(sum>0){
                    R--;
                }
            }
        }
        return result;
    }





    /**
     * 最长公共前缀 leetcode_14
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length <1){
            return "";
        }
        if(strs.length ==1){
            return strs[0];
        }

        StringBuilder sb = new StringBuilder("");
        String temp = strs[0];
        for (int j = 0; j < temp.length(); j++) {
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].length()-1 < j ||  strs[i].charAt(j) != temp.charAt(j)){
                    return sb.toString();
                }
            }
            sb.append(temp.charAt(j));
        }
        return sb.toString();
    }


    /**
     * 盛水最多的容器 leetcode_11
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {

        int area =0;
        for(int i=0,j=height.length-1;i<j;){
            area = Math.max(area, (j - i) * Math.min(height[i], height[j]));
            if (height[i] <= height[j]) {
                i++;
            } else if (height[i] > height[j]) {
                j--;
            }
        }
        return area;
    }




    /**
     * 回文数 leetcode_9
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int num = x;
        int current = 0;
        while (num != 0) {
            current = current * 10 + num % 10;
            num = num / 10;
        }
        return current ==x;
    }




    /**
     * 字符串转整数 leetcode_8
     *
     * @param str
     * @return
     */
    public static int myAtoi(String str) {
        if (str == null || str.trim().isEmpty()) {
            return 0;
        }
        long result = 0;
        int flag = 1, index = 0;
        int length = str.length();
        while (index < length && str.charAt(index) == ' ') {
            index++;
        }

        if (index == length) {
            return 0;
        }

        if (str.charAt(index) == '-' || str.charAt(index) == '+') {
            flag = str.charAt(index) == '+' ? 1 : -1;
            index++;
        }


        while (index < length) {
            int digit = str.charAt(index) - '0';
            if (digit < 0 || digit > 9) {
                break;
            }
            // 判断越界 result * 10 + digit > Integer.MAX_VALUE
            if (result > (Integer.MAX_VALUE - digit)/10) {
                return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            index++;
        }

        return (int) result * flag;
    }



    /**
     * 整数反转 leetcode_7
     *
     * @param x
     * @return
     */
    public static int reverse(int x) {
        int flag = 1;
        if (x < 0) {
            flag = -1;
            x = x * -1;
        }
        long result = 0;
        while (x > 0) {
            int temp = x % 10;
            x = x / 10;
            result = result * 10 + temp;
            if (result > Integer.MAX_VALUE) {
                return 0;
            }
        }
        return (int) (flag * result);
    }




    /**
     * Z字形变换 leetcode_6
     *
     * @param s
     * @param numRows
     * @return
     */
    public static String convert(String s, int numRows) {
        /*找每一行之间数字下标点之间的规律
          每行之间最大间距 2*numRows -2
          首尾特殊处理，其它行间距规律变化*/

        if (s == null || s.isEmpty() || s.length() < numRows || numRows == 1) {
            return s;
        }

        int maxGap = 2 * numRows - 2;
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < numRows; i++) {
            buffer.append(s.charAt(i));
            if (i == 0 || i == numRows - 1) {
                for (int j = 1; j * maxGap + i < s.length(); j++) {
                    buffer.append(s.charAt(j * maxGap + i));
                }
            } else {
                int startGap = maxGap - i * 2;
                int endGap = i * 2;
                int index = i;
                while (index < s.length()) {
                    index += startGap;
                    if (index < s.length()) {
                        buffer.append(s.charAt(index));
                    }
                    index += endGap;
                    if (index < s.length()) {
                        buffer.append(s.charAt(index));
                    }
                }
            }
        }
        return buffer.toString();
    }



    /**
     * 求最长回文子串 leetcode_5
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        int length = s.length();
        int left = 0;
        int right = 0;
        int[][] array = new int[length][length];
        for (int i = length - 1; i >= 0; i--) {
            array[i][i] = 1;
            for (int j = i + 1; j < length; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 3 || array[i + 1][j - 1] == 1)) {
                    array[i][j] = 1;
                }
                if (array[i][j] == 1 && right - left < j - i) {
                    left = i;
                    right = j;
                }
            }
        }
        return s.substring(left,right+1);
    }




    /**
     * 获取中位数 leetcode_3
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        boolean isDouble = (length1 + length2) % 2 == 0;
        int middle1 = (length1 + length2) / 2;
        int middle2 = middle1 - 1;
        int count = 0;
        double temp1 = 0, temp2 = 0;
        for (int i = 0, j = 0; count <= middle1; ) {
            if (i < length1 && j < length2) {
                if (nums1[i] <= nums2[j]) {
                    if (count == middle1) {
                        temp1 += nums1[i];
                    }
                    if (count == middle2) {
                        temp2 += nums1[i];
                    }
                    i++;
                } else {
                    if (count == middle1) {
                        temp1 += nums2[j];
                    }
                    if (count == middle2) {
                        temp2 += nums2[j];
                    }
                    j++;
                }
            } else if (i >= length1 && j < length2) {
                if (count == middle1) {
                    temp1 += nums2[j];
                }
                if (count == middle2) {
                    temp2 += nums2[j];
                }
                j++;
            } else if (i < length1 && j >= length2) {
                if (count == middle1) {
                    temp1 += nums1[i];
                }
                if (count == middle2) {
                    temp2 += nums1[i];
                }
                i++;
            }
            count++;
        }
        return isDouble ? (temp1 + temp2) / 2 : temp1;
    }





    /**
     * Leetcode_2
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        int n = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            Set<Character> set = new HashSet<>();
            int count = 0;
            for (int j = i; j < length; j++) {
                count++;
                set.add(s.charAt(j));
                if (set.size() < count) {
                    count-= 1;
                    break;
                }
            }
            n = Math.max(n, count);
        }
        return n;
    }
}
