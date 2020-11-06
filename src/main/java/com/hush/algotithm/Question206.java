package com.hush.algotithm;

/**
 * @Author: huangshuai
 * @Date: 2020-11-03
 * @Version 1.0
 */
public class Question206 {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static  ListNode reverseList(ListNode head) {

        if(head ==null){
            return head;
        }

        ListNode previous = null;
        ListNode current = head;
        while(current.next!=null){
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        current.next = previous;
        return current;
    }


    public static void main(String[] args) {

    }
}
