package com.hush.algotithm;

/**
 * @Author: huangshuai
 * @Date: 2020-07-09
 * @Version 1.0
 */
public class Question21 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * 合并链表 leetcode_21
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode current = null;
        ListNode next = null;

        if (l1.val <= l2.val) {
            current = l1;
            l1 = l1.next;
        } else {
            current = l2;
            l2 = l2.next;
        }
        next = mergeTwoLists(l1, l2);
        current.next = next;
        return current;
    }


    public static void main(String[] args) {

    }

}
