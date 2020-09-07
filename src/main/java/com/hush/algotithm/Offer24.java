package com.hush.algotithm;

/**
 * @Author: huangshuai
 * @Date: 2020-07-09
 * @Version 1.0
 */
public class Offer24 {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static  ListNode reverseList(ListNode head) {

        if (head == null) {
            return head;
        }
        ListNode previous = null;
        ListNode current = head;
        ListNode newhead  =null;

        while (current != null) {
            newhead = current;
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return newhead;
    }


    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);



        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode node = reverseList(node1);

        while(node!=null){
            System.out.println(node.val);
            node =node.next;
        }

    }


}
