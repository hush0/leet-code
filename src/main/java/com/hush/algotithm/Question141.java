package com.hush.algotithm;

/**
 * @Author: huangshuai
 * @Date: 2020-10-26
 * @Version 1.0
 */
public class Question141 {


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static boolean hasCycle(ListNode head) {

        if(head ==null){
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {

    }
}
