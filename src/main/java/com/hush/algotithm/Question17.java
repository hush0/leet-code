package com.hush.algotithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: huangshuai
 * @Date: 2020-07-09
 * @Version 1.0
 */
public class Question17 {


    /**
     * 普通循环添加方法
     * @param digits
     * @return
     */
    /*public static List<String> letterCombinations(String digits) {

        Map<Character ,char[]> map = new HashMap<>();
        map.put('1',null);
        map.put('2',new char[]{'a','b','c'});
        map.put('3',new char[]{'d','e','f'});
        map.put('4',new char[]{'g','h','i'});
        map.put('5',new char[]{'j','k','l'});
        map.put('6',new char[]{'m','n','o'});
        map.put('7',new char[]{'p','q','r','s'});
        map.put('8',new char[]{'t','u','v'});
        map.put('9',new char[]{'w','x','y','z'});

        List<String> list = new ArrayList<>();
        int length = digits.length();

        for (int i = 0; i < length; i++) {
            char[] array = map.get(digits.charAt(i));
            if (list.size() == 0) {
                for (int j = 0; j < array.length; j++) {
                    list.add(String.valueOf(array[j]));
                }
            } else {
                List<String> newList = new ArrayList<>();
                for (int j = 0; j < list.size(); j++) {
                    for (int k = 0; k < array.length; k++) {
                        newList.add(list.get(j) + array[k]);
                    }
                }
                list.clear();
                list.addAll(newList);
            }
        }
        return list;

    }*/


    /**
     * 回溯
     * @param digits
     */
    public static List<String> letterCombinations(String digits) {

        List<String> list = new ArrayList<>();
        if(digits == null || digits.length() ==0){
            return list;
        }

        Map<Character ,char[]> map = new HashMap<>();
        map.put('1',null);
        map.put('2',new char[]{'a','b','c'});
        map.put('3',new char[]{'d','e','f'});
        map.put('4',new char[]{'g','h','i'});
        map.put('5',new char[]{'j','k','l'});
        map.put('6',new char[]{'m','n','o'});
        map.put('7',new char[]{'p','q','r','s'});
        map.put('8',new char[]{'t','u','v'});
        map.put('9',new char[]{'w','x','y','z'});

        backtrack(list,map,0,digits,new StringBuffer());
        return list;

    }


    public static void backtrack(List<String> collection, Map<Character, char[]> map, int index, String digits, StringBuffer sb) {

        if (index == digits.length()) {
            collection.add(sb.toString());
        } else {
            char[] array = map.get(digits.charAt(index));
            for (int i = 0; i < array.length; i++) {
                sb.append(String.valueOf(array[i]));
                backtrack(collection,map,index+1,digits,sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }

    }






    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

}
