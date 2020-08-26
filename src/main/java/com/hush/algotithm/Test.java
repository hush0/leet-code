package com.hush.algotithm;


import com.sun.xml.internal.ws.util.StringUtils;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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


        System.out.println(reverse(-12030));


    }


    /**
     * 字符串转整数 leetcode8
     *
     * @param str
     * @return
     */
    public int myAtoi(String str) {

        return 0;
    }



    /**
     * 整数反转 leetcode7
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
     * Z字形变换 leetcode 6
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
     * 求最长回文子串 leetcode5
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
     * leetcode3 获取中位数
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
     * Leetcode-3
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
