package com.hush.algotithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static javax.swing.UIManager.put;

/**
 * @Author: huangshuai
 * @Date: 2020-11-03
 * @Version 1.0
 */
public class Question20 {


   /* public static boolean isValid(String s) {

        int length = s.length();
        Stack<Character> stack1  = new Stack<>();
        Stack<Character> stack2  = new Stack<>();
        for(int i=0;i<length;i++){
            stack1.push(s.charAt(i));
        }

        while (stack2.size() < stack1.size()) {
            Character ch = stack1.pop();
            stack2.push(ch);
            while (!stack1.isEmpty() && !stack2.isEmpty()  && isMatch(stack1.peek(), stack2.peek())) {
                stack1.pop();
                stack2.pop();
            }
        }

        if (stack1.size() == 0 && stack2.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
*/

    public static  boolean isMatch(char ch1 ,char ch2){
        if(ch1 == '(' && ch2 == ')'){
            return true;
        }
        if(ch1 == '[' && ch2 == ']'){
            return true;
        }
        if(ch1 == '{' && ch2 == '}'){
            return true;
        }
        return false;
    }







    public static boolean isValid(String s) {
        if(s.isEmpty() || s==null){
            return true;
        }
        Stack<Character> stack  = new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch == '(' || ch== '[' || ch == '{'){
                stack.push(ch);
            } else {
               if(!stack.isEmpty() && isMatch(stack.peek(), ch)){
                   stack.pop();
               } else {
                   return false;
               }
            }
        }

        if(stack.isEmpty()){
            return true;
        } else {
            return false;
        }

    }


    public static void main(String[] args) {

        System.out.println(isValid("{[]}"));

    }
}
